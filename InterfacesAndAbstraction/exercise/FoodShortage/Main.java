package InterfacesAndAbstraction.exercise.FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Citizen> citizens = new ArrayList<>();
        List<Rebel> rebels = new ArrayList<>();

        int countPeople = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < countPeople; i++) {
            String input = scan.nextLine();
            String[] data = input.split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Citizen citizen;
            Rebel rebel;

            if (data.length == 4) {
                String id = data[2];
                String birthday = data[3];
                citizen = new Citizen(name, age, id, birthday);
                citizens.add(citizen);
            } else if (data.length == 3) {
                String group = data[2];
                rebel = new Rebel(name, age, group);
                rebels.add(rebel);
            }
        }
        String name = scan.nextLine();
        while (!name.equals("End")) {
            String finalName = name;

            citizens = citizens.stream().peek(c -> {
                if (c.getName().equals(finalName)) {
                    c.buyFood();
                }
            }).collect(Collectors.toList());

            rebels = rebels.stream().peek(r -> {
                if (r.getName().equals(finalName)) {
                    r.buyFood();
                }
            }).collect(Collectors.toList());

            name = scan.nextLine();
        }
        int sum = citizens.stream().mapToInt(Citizen::getFood).sum() + rebels.stream().mapToInt(Rebel::getFood).sum();
        System.out.println(sum);
    }
}
