package Encapsulation.exercise.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int toppingsCount;

    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setToppings(int toppings) {
        if (toppings < 0 || toppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppingsCount = toppings;
    }

    public Pizza(String name, int toppingsCount) {
        setName(name);
        setToppings(toppingsCount);
        this.toppings = new ArrayList<>();
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return this.name;
    }

    public void addTopping(Topping topping) {
        if (this.toppingsCount + 1 > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppingsCount++;
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        double result = 0;
        for (int i = 0; i < this.toppings.size(); i++) {
            result += this.toppings.get(i).calculateCalories();
        }
        result += this.dough.calculateCalories();
        return result;
    }
}
