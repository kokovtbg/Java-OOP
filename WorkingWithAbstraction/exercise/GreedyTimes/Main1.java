
package WorkingWithAbstraction.exercise.GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] data = scanner.nextLine().split("\\s+");

        var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long gold = 0;
        long gems = 0;
        long cash = 0;

        for (int i = 0; i < data.length; i += 2) {
            String name = data[i];
            long amount = Long.parseLong(data[i + 1]);

            String typeTreasure = "";

            if (name.length() == 3) {
                typeTreasure = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                typeTreasure = "Gem";
            } else if (name.equalsIgnoreCase("gold")) {
                typeTreasure = "Gold";
            }

            if (typeTreasure.equals("")) {
                continue;
            } else if (capacity < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + amount) {
                continue;
            }

            switch (typeTreasure) {
                case "Gem":
                    if (!bag.containsKey(typeTreasure)) {
                        if (bag.containsKey("Gold")) {
                            if (amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(typeTreasure).values().stream().mapToLong(e -> e).sum() + amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(typeTreasure)) {
                        if (bag.containsKey("Gem")) {
                            if (amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(typeTreasure).values().stream().mapToLong(e -> e).sum() + amount > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(typeTreasure)) {
                bag.put((typeTreasure), new LinkedHashMap<>());
            }

            if (!bag.get(typeTreasure).containsKey(name)) {
                bag.get(typeTreasure).put(name, 0L);
            }


            bag.get(typeTreasure).put(name, bag.get(typeTreasure).get(name) + amount);
            if (typeTreasure.equals("Gold")) {
                gold += amount;
            } else if (typeTreasure.equals("Gem")) {
                gems += amount;
            } else if (typeTreasure.equals("Cash")) {
                cash += amount;
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}