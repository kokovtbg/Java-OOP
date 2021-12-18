package Polymorphism.exercise.Calculator.calculator;

import java.util.ArrayList;
import java.util.List;

public class MemorySave {
    private List<Integer> memories;

    public MemorySave() {
        this.memories = new ArrayList<>();
    }

    protected List<Integer> getMemories() {
        return memories;
    }

    public void setMemories(int number) {
        this.memories.add(number);
    }

    public String recall() {
        return String.valueOf(this.getMemories().remove(this.memories.size() - 1));
    }
}
