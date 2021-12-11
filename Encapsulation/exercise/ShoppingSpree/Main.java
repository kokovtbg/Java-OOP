package Encapsulation.exercise.ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(";");

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            String[] split = input[i].split("=");
            String name = split[0];
            double money = Double.parseDouble(split[1]);
            Person person = new Person(name, money);
            people.add(person);
        }
        String[] data = scan.nextLine().split(";");

        List<Product> products = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            String[] split = data[i].split("=");
            String name = split[0];
            double cost = Double.parseDouble(split[1]);
            Product product = new Product(name, cost);
            products.add(product);
        }

        String command = scan.nextLine();
        while (!command.equals("END")) {
            String namePerson = command.split("\\s+")[0];
            String nameProduct = command.split("\\s+")[1];
            Product product = null;
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getName().equals(nameProduct)) {
                    product = products.get(i);
                }
            }
            for (int i = 0; i < people.size(); i++) {
                if (people.get(i).getName().equals(namePerson) && product != null) {
                    people.get(i).buyProduct(product);
                }
            }

            command = scan.nextLine();
        }

        for (int i = 0; i < people.size(); i++) {
            System.out.printf("%s - ", people.get(i).getName());
            if (people.get(i).getProductsCount() > 0) {
                System.out.println(String.join(", ", people.get(i).getProducts().toString().replaceAll("[\\[\\]]", "")));
            } else {
                System.out.println("Nothing bought");
            }
        }
    }
}
