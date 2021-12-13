package Exams.Exam12December2020.bakery.repositories.entities.drinks;

public class Water extends BaseDrink {
    private static final double WATER_PRICE = 1.50;

    public Water(String name, int portion, String brand) {
        super(name, portion, WATER_PRICE, brand);
    }
}
