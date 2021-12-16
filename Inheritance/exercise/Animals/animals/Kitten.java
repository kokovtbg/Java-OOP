package Inheritance.exercise.Animals.animals;

public class Kitten extends Cat {

    public Kitten(String name, int age) {
        super(name, age, "Female");
        super.setSound("Meow");
    }
}
