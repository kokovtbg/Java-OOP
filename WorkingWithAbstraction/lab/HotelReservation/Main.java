package WorkingWithAbstraction.lab.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] data = input.split("\\s+");
        double pricePerDay = Double.parseDouble(data[0]);
        int days = Integer.parseInt(data[1]);
        String season = data[2];
        String discountType = data[3];

        PriceCalculator.Season season1 = null;

        if (season.equals("Autumn")) {
            season1 = PriceCalculator.Season.Autumn;
        } else if (season.equals("Spring")) {
            season1 = PriceCalculator.Season.Spring;
        } else if (season.equals("Winter")) {
            season1 = PriceCalculator.Season.Winter;
        } else if (season.equals("Summer")) {
            season1 = PriceCalculator.Season.Summer;
        }

        PriceCalculator.DiscountType discountType1 = null;

        if (discountType.equals("VIP")) {
            discountType1 = PriceCalculator.DiscountType.VIP;
        } else if (discountType.equals("SecondVisit")) {
            discountType1 = PriceCalculator.DiscountType.SecondVisit;
        } else if (discountType.equals("None")) {
            discountType1 = PriceCalculator.DiscountType.None;
        }

        System.out.printf("%.2f", PriceCalculator.calculate(pricePerDay, days, season1, discountType1));
    }
}
