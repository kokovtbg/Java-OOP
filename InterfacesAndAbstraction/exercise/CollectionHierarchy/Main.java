package InterfacesAndAbstraction.exercise.CollectionHierarchy;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> elements = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        int removeOperations = Integer.parseInt(scan.nextLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        try {
            elements.forEach(e -> System.out.print(addCollection.add(e) + " "));
            System.out.println();
            elements.forEach(e -> System.out.print(addRemoveCollection.add(e) + " "));
            System.out.println();
            elements.forEach(e -> System.out.print(myList.add(e) + " "));
            System.out.println();
        } catch (IndexOutOfBoundsException ignored) {

        }
        for (int i = 0; i < removeOperations; i++) {
            System.out.print(addRemoveCollection.remove() + " ");
        }
        if (removeOperations > 0) {
            System.out.println();
        }
        for (int i = 0; i < removeOperations; i++) {
            System.out.print(myList.remove() + " ");
        }
    }
}
