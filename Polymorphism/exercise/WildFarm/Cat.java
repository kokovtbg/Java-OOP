package Polymorphism.exercise.WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    protected Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    protected void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    protected void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    protected void eatFood(Food food) {
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, " + decimalFormat.format(this.getAnimalWeight()) + ", %s, %d]", this.getAnimalType(), this.getAnimalName(), this.getBreed(), this.getLivingRegion(), this.getFoodEaten());
    }
}
