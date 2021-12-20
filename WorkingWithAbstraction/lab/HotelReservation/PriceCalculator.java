package WorkingWithAbstraction.lab.HotelReservation;

public class PriceCalculator {
    enum Season {
        Autumn(1), Spring(2), Winter(3), Summer(4);
        private int multiplier;

        Season(int multiplier) {
            this.multiplier = multiplier;
        }

        public int getMultiplier() {
            return this.multiplier;
        }
    }
    enum DiscountType {
        VIP(0.8), SecondVisit(0.9), None(1);
        private double discount;

        DiscountType(double discount) {
            this.discount = discount;
        }

        public double getDiscount() {
            return this.discount;
        }
    }
    public static double calculate(double pricePerDay, int days, Season season, DiscountType discountType) {
        int multiplier = season.getMultiplier();
        double discount = discountType.getDiscount();
        return pricePerDay * days * multiplier * discount;
    }
}
