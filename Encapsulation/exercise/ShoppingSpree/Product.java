package Encapsulation.exercise.ShoppingSpree;

public class Product {
    private String name;
    private double cost;

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }

    public Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

    @Override
    public String toString() {
        return String.format("%s", this.getName());
    }
}
