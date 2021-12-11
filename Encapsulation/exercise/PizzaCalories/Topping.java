package Encapsulation.exercise.PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;
    private double modifier;

    private void setToppingType(String toppingType) {
        if (!toppingType.equalsIgnoreCase("meat") && !toppingType.equalsIgnoreCase("veggies") && !toppingType.equalsIgnoreCase("cheese") && !toppingType.equalsIgnoreCase("sauce")) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }
    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
        this.modifier = 1;
    }

    public double calculateCalories() {
        if (this.toppingType.equalsIgnoreCase("meat")) {
            this.modifier *= 1.2;
        } else if (this.toppingType.equalsIgnoreCase("veggies")) {
            this.modifier *= 0.8;
        } else if (this.toppingType.equalsIgnoreCase("cheese")) {
            this.modifier *= 1.1;
        } else if (this.toppingType.equalsIgnoreCase("sauce")) {
            this.modifier *= 0.9;
        }
        return 2 * this.weight * this.modifier;
    }
}
