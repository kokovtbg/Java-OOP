package InterfacesAndAbstraction.exercise.CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private static final int maxSize = 100;
    private List<String> items;

    public Collection() {
        this.items = new ArrayList<>(maxSize);
    }

    public static int getMaxSize() {
        return maxSize;
    }

    public List<String> getItems() {
        return items;
    }
}
