package DesignPatterns.BuilderPattern;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza().withWeight(200).withName("Margarita").withTopping("A");
        Pizza pizza2 = new Pizza().withWeight(200).withName("Margarita").withTopping("A");

    }
}
