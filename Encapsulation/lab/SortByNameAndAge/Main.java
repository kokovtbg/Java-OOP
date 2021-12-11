package Encapsulation.lab.SortByNameAndAge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            Person person = new Person(firstName, lastName, age);
            people.add(person);
        }
        Collections.sort(people, (firstPerson, secondPerson) -> {
            int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());
            if (sComp != 0) {
                return sComp;
            } else {
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }
        });
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
