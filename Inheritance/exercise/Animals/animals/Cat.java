package Inheritance.exercise.Animals.animals;

public class Cat extends Animal {

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
        super.setSound("Meow meow");
    }
}
