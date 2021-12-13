package Exams.Exam12December2020.bakery.repositories.entities.bakedFoods;

public class Cake extends BaseFood {
    private static final double INITIAL_CAKE_PORTION = 245;

    public Cake(String name, double price) {
        super(name, INITIAL_CAKE_PORTION, price);
    }
}
