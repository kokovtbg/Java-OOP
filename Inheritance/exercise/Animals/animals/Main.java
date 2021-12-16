package Inheritance.exercise.Animals.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        List<Animal> animals = new ArrayList<>();
        while (!input.equals("Beast!")) {
            String[] data = scan.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String gender = "";
            if (data.length == 3) {
                gender = data[2];
            }
            Animal animal = null;
            if (input.equals("Cat")) {
                animal = new Cat(name, age, gender);
            } else if (input.equals("Dog")) {
                animal = new Dog(name, age, gender);
            } else if (input.equals("Frog")) {
                animal = new Frog(name, age, gender);
            } else if (input.equals("Kittens")) {
                animal = new Kitten(name, age);
            } else if (input.equals("Tomcat")) {
                animal = new Tomcat(name, age);
            }
            animals.add(animal);

            input = scan.nextLine();
        }
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i));
            System.out.println(animals.get(i).produceSound());
        }
    }
}
