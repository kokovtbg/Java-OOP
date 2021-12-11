package Encapsulation.exercise.ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public void buyProduct(Product product) {
        if (this.money - product.getCost() >= 0) {
            this.money -= product.getCost();
            this.products.add(product);
            System.out.printf("%s bought %s%n", this.name, product.getName());
        } else {
            throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
        }
    }

    public String getName() {
        return name;
    }

    public int getProductsCount() {
        return this.products.size();
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
