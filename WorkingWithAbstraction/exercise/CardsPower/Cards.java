package WorkingWithAbstraction.exercise.CardsPower;

public class Cards {
    enum Rank {
        ACE(14), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);
        private int value;

        Rank(int value) {
            this.value = value;
        }
        public int getValue() {
            return this.value;
        }
    }
    enum Suit {
        CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);
        private int value;

        Suit(int value) {
            this.value = value;
        }
        public int getValue() {
            return this.value;
        }
    }
    public static int power(Rank rank, Suit suit) {
        return rank.getValue() + suit.getValue();
    }
}
