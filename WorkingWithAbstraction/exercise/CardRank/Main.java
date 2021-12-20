package WorkingWithAbstraction.exercise.CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if (input.equals("Card Ranks")) {
            Cards.printCards();
        }
    }
}
