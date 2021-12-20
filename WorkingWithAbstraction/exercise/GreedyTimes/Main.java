package WorkingWithAbstraction.exercise.GreedyTimes;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long capacity = Long.parseLong(scan.nextLine());
        String input = scan.nextLine();
        Map<String, Map<String, Long>> bag = new LinkedHashMap<>();
        Map<String, Long> goldBag = new LinkedHashMap<>();
//        goldBag.put("Gold", 0);
//        bag.put("gold", goldBag);
        Map<String, Long> gemBag = new LinkedHashMap<>();
//        bag.put("gem", gemBag);
        Map<String, Long> cashBag = new LinkedHashMap<>();
//        bag.put("cash", cashBag);
        String[] data = input.split("\\s+");
        String typeTreasure = "";
        for (int i = 0; i < data.length; i++) {
            long amount;
            if (i % 2 == 0) {
                if (data[i].length() == 3) {
                    typeTreasure = data[i];
                } else if (data[i].toLowerCase().endsWith("gem")) {
                    typeTreasure = data[i];
                } else if (data[i].equalsIgnoreCase("gold")) {
                    typeTreasure = data[i];
                }
            } else {
                amount = Long.parseLong(data[i]);
                if (typeTreasure.length() == 3) {
                    boolean alreadyInBag = false;
                    for (Map.Entry<String, Long> entry : cashBag.entrySet()) {
                        if (entry.getKey().equalsIgnoreCase(typeTreasure) && (cashBag.values().stream().mapToLong(e -> e).sum() + amount <= gemBag.values().stream().mapToLong(e -> e).sum())) {
                            alreadyInBag = true;
                            if (!gemBag.isEmpty()) {
                                if (cashBag.values().stream().mapToLong(e -> e).sum() + gemBag.values().stream().mapToLong(e -> e).sum() + goldBag.values().stream().mapToLong(e -> e).sum() + amount <= capacity) {
                                    entry.setValue(entry.getValue() + amount);
                                }
                            }
                        }
                    }
                    if (!alreadyInBag && (cashBag.values().stream().mapToLong(e -> e).sum() + amount <= gemBag.values().stream().mapToLong(e -> e).sum())) {
                        if (cashBag.values().stream().mapToLong(e -> e).sum() + gemBag.values().stream().mapToLong(e -> e).sum() + goldBag.values().stream().mapToLong(e -> e).sum() + amount <= capacity) {
                            cashBag.put(typeTreasure, amount);
                        }
                    }
                } else if (typeTreasure.toLowerCase().contains("gem")) {
                    boolean alReadyInBag = false;
                    for (Map.Entry<String, Long> entry : gemBag.entrySet()) {
                        if (entry.getKey().equalsIgnoreCase(typeTreasure) && (gemBag.values().stream().mapToLong(e -> e).sum() + amount <= goldBag.values().stream().mapToLong(e -> e).sum())) {
                            alReadyInBag = true;
                            if (!goldBag.isEmpty()) {
                                if (cashBag.values().stream().mapToLong(e -> e).sum() + gemBag.values().stream().mapToLong(e -> e).sum() + goldBag.values().stream().mapToLong(e -> e).sum() + amount <= capacity) {
                                    entry.setValue(entry.getValue() + amount);
                                }
                            }
                        }
                    }
                    if (!alReadyInBag && (gemBag.values().stream().mapToLong(e -> e).sum() + amount <= goldBag.values().stream().mapToLong(e -> e).sum())) {
                        if (cashBag.values().stream().mapToLong(e -> e).sum() + gemBag.values().stream().mapToLong(e -> e).sum() + goldBag.values().stream().mapToLong(e -> e).sum() + amount <= capacity) {
                            gemBag.put(typeTreasure, amount);
                        }
                    }
                } else if (typeTreasure.equalsIgnoreCase("gold")) {
                    boolean alreadyInBag = false;
                    for (Map.Entry<String, Long> entry : goldBag.entrySet()) {
                        if (entry.getKey().equalsIgnoreCase(typeTreasure) && (cashBag.values().stream().mapToLong(e -> e).sum() + gemBag.values().stream().mapToLong(e -> e).sum() + goldBag.values().stream().mapToLong(e -> e).sum() + amount <= capacity)) {
                            entry.setValue(entry.getValue() + amount);
                            alreadyInBag = true;
                        }
                    }
                    if (!alreadyInBag) {
                        if (cashBag.values().stream().mapToLong(e -> e).sum() + gemBag.values().stream().mapToLong(e -> e).sum() + goldBag.values().stream().mapToLong(e -> e).sum() + amount <= capacity) {
                            goldBag.put(typeTreasure, amount);
                        }
                    }
                }
            }
        }
        bag.put("gold", goldBag);
        gemBag = gemBag.entrySet().stream().sorted((e1, e2) -> {
            int result = e2.getKey().compareTo(e1.getKey());
            if (result == 0) {
                result = Long.compare(e1.getValue(), e2.getValue());
            }
            return result;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
        bag.put("gem", gemBag);
        cashBag = cashBag.entrySet().stream().sorted((e1, e2) -> {
            int result = e2.getKey().compareTo(e1.getKey());
            if (result == 0) {
                result = Long.compare(e1.getValue(), e2.getValue());
            }
            return result;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
        bag.put("cash", cashBag);
        bag = bag.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue().values().stream().mapToLong(e -> e).sum(), e1.getValue().values().stream().mapToLong(e -> e).sum())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
        for (Map.Entry<String, Map<String, Long>> entry : bag.entrySet()) {
            int sum = 0;
            for (Map.Entry<String, Long> entry2 : entry.getValue().entrySet()) {
                sum += entry2.getValue();
            }
            if (sum != 0) {
                System.out.printf("<%s> $%d%n", entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1), sum);
                for (Map.Entry<String, Long> entry2 : entry.getValue().entrySet()) {
                    System.out.printf("##%s - %d%n", entry2.getKey(), entry2.getValue());
                }
            }
        }
    }
}
