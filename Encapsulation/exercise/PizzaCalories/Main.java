package Encapsulation.exercise.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] pizzaData = scan.nextLine().split("\\s+");
        String pizzaName = pizzaData[1];
        int pizzaToppings = Integer.parseInt(pizzaData[2]);
        Pizza pizza = new Pizza(pizzaName, pizzaToppings);
        String[] doughData = scan.nextLine().split("\\s+");
        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        double doughWeight = Double.parseDouble(doughData[3]);
        Dough dough = new Dough(flourType, bakingTechnique, doughWeight);
        pizza.setDough(dough);
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] toppingData = input.split("\\s+");
            String toppingType = toppingData[1];
            double toppingWeight = Double.parseDouble(toppingData[2]);
            Topping topping = new Topping(toppingType, toppingWeight);
            pizza.addTopping(topping);

            input = scan.nextLine();
        }
        System.out.printf("%s - %.2f", pizzaName, pizza.getOverallCalories());
    }
}
