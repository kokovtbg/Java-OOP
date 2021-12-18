package Polymorphism.exercise.WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] splitData = input.split("\\s+");
            String animalType = splitData[0];
            String animalName = splitData[1];
            double animalWeight = Double.parseDouble(splitData[2]);
            String livingRegion = splitData[3];
            Animal animal = null;
            if (animalType.equals("Cat")) {
                String breed = splitData[4];
                animal = new Cat(animalType, animalName, animalWeight, livingRegion, breed);
            } else {
                switch (animalType) {
                    case "Mouse":
                        animal = new Mouse(animalType, animalName, animalWeight, livingRegion);
                        break;
                    case "Tiger":
                        animal = new Tiger(animalType, animalName, animalWeight, livingRegion);
                        break;
                    case "Zebra":
                        animal = new Zebra(animalType, animalName, animalWeight, livingRegion);
                        break;
                }
            }
            String[] typeFoodAndQuantity = scan.nextLine().split("\\s+");
            String typeFood = typeFoodAndQuantity[0];
            Integer quantity = Integer.parseInt(typeFoodAndQuantity[1]);
            Food food;
            if (typeFood.equals("Vegetable")) {
                food = new Vegetable(quantity);
            } else {
                food = new Meat(quantity);
            }
            animal.makeSound();
            try {
                animal.eatFood(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            animals.add(animal);

            input = scan.nextLine();
        }
        animals.forEach(System.out::println);
    }
}
