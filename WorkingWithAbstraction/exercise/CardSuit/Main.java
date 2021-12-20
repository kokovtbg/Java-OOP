package WorkingWithAbstraction.exercise.CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if (input.equals("Card Suits")) {
            Cards.printCards();
        }
    }
}
