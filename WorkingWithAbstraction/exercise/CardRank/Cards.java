package WorkingWithAbstraction.exercise.CardRank;

public class Cards {
    enum Card {
        ACE(0), TWO(1), THREE(2), FOUR(3), FIVE(4), SIX(5), SEVEN(6), EIGHT(7), NINE(8), TEN(9), JACK(10), QUEEN(11), KING(12);

        private int value;
        Card(int value) {
            this.value = value;
        }
        public int getValue() {
            return this.value;
        }
    }
    public static void printCards() {
        System.out.println("Card Ranks:");
        System.out.printf("Ordinal value: %d; Name value: %s%n", Card.ACE.getValue(), Card.ACE);
        System.out.printf("Ordinal value: %d; Name value: %s%n", Card.TWO.getValue(), Card.TWO);
        System.out.printf("Ordinal value: %d; Name value: %s%n", Card.THREE.getValue(), Card.THREE);
        System.out.printf("Ordinal value: %d; Name value: %s%n", Card.FOUR.getValue(), Card.FOUR);
        System.out.printf("Ordinal value: %d; Name value: %s%n", Card.FIVE.getValue(), Card.FIVE);
        System.out.printf("Ordinal value: %d; Name value: %s%n", Card.SIX.getValue(), Card.SIX);
        System.out.printf("Ordinal value: %d; Name value: %s%n", Card.SEVEN.getValue(), Card.SEVEN);
        System.out.printf("Ordinal value: %d; Name value: %s%n", Card.EIGHT.getValue(), Card.EIGHT);
        System.out.printf("Ordinal value: %d; Name value: %s%n", Card.NINE.getValue(), Card.NINE);
        System.out.printf("Ordinal value: %d; Name value: %s%n", Card.TEN.getValue(), Card.TEN);
        System.out.printf("Ordinal value: %d; Name value: %s%n", Card.JACK.getValue(), Card.JACK);
        System.out.printf("Ordinal value: %d; Name value: %s%n", Card.QUEEN.getValue(), Card.QUEEN);
        System.out.printf("Ordinal value: %d; Name value: %s%n", Card.KING.getValue(), Card.KING);
    }
}
