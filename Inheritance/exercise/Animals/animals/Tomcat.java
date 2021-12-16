package Inheritance.exercise.Animals.animals;

public class Tomcat extends Cat {

    public Tomcat(String name, int age) {
        super(name, age, "Male");
        super.setSound("MEOW");
    }
}
