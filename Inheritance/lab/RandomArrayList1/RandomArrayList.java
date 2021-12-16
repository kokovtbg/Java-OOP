package Inheritance.lab.RandomArrayList1;

import java.util.ArrayList;

public class RandomArrayList<T> extends ArrayList<T> {
    public RandomArrayList() {
        super();
    }

    public T getRandomElement(T element) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).toString().equals(element)) {
                return super.remove(i);
            }
        }
        return null;
    }
}
