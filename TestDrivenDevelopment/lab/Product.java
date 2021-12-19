package TestDrivenDevelopment.lab;

import java.util.Iterator;

public class Product implements Comparable<Product>, Iterable<Product> {

    private String label;

    private double price;

    private int quantity;

    public Product(String label, double price, int quantity) {
        this.label = label;
        this.price = price;
        this.quantity = quantity;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Product o) {
        return this.getLabel().compareTo(o.getLabel());
    }

    @Override
    public Iterator<Product> iterator() {
        return null;
    }
}
