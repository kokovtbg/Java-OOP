package Inheritance.exercise.Animals.animals;

public class Dog extends Animal {

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
        super.setSound("Woof!");
    }
}
