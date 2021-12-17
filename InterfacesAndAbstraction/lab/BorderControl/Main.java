package InterfacesAndAbstraction.lab.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Identifiable> peoplePlusRobots = new ArrayList<>();

        String input = scan.nextLine();
        while (!input.equals("End")) {

            String[] data = input.split("\\s+");
            Identifiable identifiable = null;

            if (data.length == 2) {
                String model = data[0];
                String id = data[1];
                identifiable = new Robot(model, id);
            } else if (data.length == 3) {
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];
                identifiable = new Citizen(name, age, id);
            }
            peoplePlusRobots.add(identifiable);

            input = scan.nextLine();
        }

        String lastDigits = scan.nextLine();
        for (int i = 0; i < peoplePlusRobots.size(); i++) {
            if (peoplePlusRobots.get(i).getId().endsWith(lastDigits)) {
                System.out.println(peoplePlusRobots.get(i).getId());
            }
        }
    }
}
