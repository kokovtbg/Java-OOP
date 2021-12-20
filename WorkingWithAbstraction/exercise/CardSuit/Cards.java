package WorkingWithAbstraction.exercise.CardSuit;

import java.util.List;

public class Cards {
    enum Card {
        CLUBS(0), DIAMONDS(1), HEARTS(2), SPADES(3);
        private int value;

        Card(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
    public static void printCards() {
        System.out.println("Card Suits:");
        System.out.printf("Ordinal value: %d; Name value: %s%n", Card.CLUBS.getValue(), Card.CLUBS);
        System.out.printf("Ordinal value: %d; Name value: %s%n", Card.DIAMONDS.getValue(), Card.DIAMONDS);
        System.out.printf("Ordinal value: %d; Name value: %s%n", Card.HEARTS.getValue(), Card.HEARTS);
        System.out.printf("Ordinal value: %d; Name value: %s%n", Card.SPADES.getValue(), Card.SPADES);
    }
}
