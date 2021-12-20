package WorkingWithAbstraction.exercise.CardsPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rankName = scan.nextLine();
        String suitName = scan.nextLine();
        Cards.Rank rank = Cards.Rank.valueOf(rankName);
        Cards.Suit suit = Cards.Suit.valueOf(suitName);
        System.out.println("Card name: " + rankName + " of " + suitName + "; Card power: " + Cards.power(rank, suit));
    }
}
