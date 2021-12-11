package Encapsulation.lab.ValidationData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String firstname = input[0];
            String lastname = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);
            Person person = new Person(firstname, lastname, age, salary);
            people.add(person);
        }
        double bonus = Double.parseDouble(scan.nextLine());
        for (int i = 0; i < people.size(); i++) {
            people.get(i).increaseSalary(bonus);
            System.out.println(people.get(i));
        }
    }
}
