package Inheritance.lab.StackOfStrings1;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String element) {
        this.data.add(0, element);
    }

    public String pop() {
        if (!this.data.isEmpty()) {
            return this.data.remove(0);
        }
        return null;
    }

    public String peek() {
        if (!this.data.isEmpty()) {
            return this.data.get(0);
        }
        return null;
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
