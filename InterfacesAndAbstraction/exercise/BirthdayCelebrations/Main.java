package InterfacesAndAbstraction.exercise.BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Citizen> citizens = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();

        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String typeObject = data[0];

            Citizen citizen;
            Pet pet;

            if (typeObject.equals("Citizen")) {
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String id = data[3];
                String birthDate = data[4];
                citizen = new Citizen(name, age, id, birthDate);
                citizens.add(citizen);
            }  else if (typeObject.equals("Pet")) {
                String name = data[1];
                String birthDate = data[2];
                pet = new Pet(name, birthDate);
                pets.add(pet);
            }

            input = scan.nextLine();
        }
        String year = scan.nextLine();
        boolean haveBirthDate = false;
        for (int i = 0; i < citizens.size(); i++) {
            if (citizens.get(i).getBirthDate().endsWith(year)) {
                System.out.println(citizens.get(i).getBirthDate());
                haveBirthDate = true;
            }
        }
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getBirthDate().endsWith(year)) {
                System.out.println(pets.get(i).getBirthDate());
                haveBirthDate = true;
            }
        }
        if (!haveBirthDate) {
            System.out.println("<no output>");
        }
    }
}
