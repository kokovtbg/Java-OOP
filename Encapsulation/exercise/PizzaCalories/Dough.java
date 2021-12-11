package Encapsulation.exercise.PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;
    private double modifier;

    private void setFlourType(String flourType) {
        if (!flourType.equalsIgnoreCase("white") && !flourType.equalsIgnoreCase("wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equalsIgnoreCase("crispy") && !bakingTechnique.equalsIgnoreCase("chewy") && !bakingTechnique.equalsIgnoreCase("homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
        this.modifier = 1;
    }

    public double calculateCalories() {
        if (this.flourType.equalsIgnoreCase("white")) {
            this.modifier *= 1.5;
        } else if (this.flourType.equalsIgnoreCase("wholegrain")) {
            this.modifier *= 1;
        }
        if (this.bakingTechnique.equalsIgnoreCase("crispy")) {
            this.modifier *= 0.9;
        } else if (this.bakingTechnique.equalsIgnoreCase("chewy")) {
            this.modifier *= 1.1;
        } else if (this.bakingTechnique.equalsIgnoreCase("homemade")) {
            this.modifier *= 1;
        }
        return 2 * weight * modifier;
    }
}
