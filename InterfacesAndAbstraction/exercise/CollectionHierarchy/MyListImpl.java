package InterfacesAndAbstraction.exercise.CollectionHierarchy;


public class MyListImpl extends Collection implements MyList {

    public MyListImpl() {
        super();
    }

    @Override
    public String remove() {
        return super.getItems().remove(0);
    }

    @Override
    public int add(String element) {
        if (super.getItems().size() < getMaxSize()) {
            super.getItems().add(0, element);
            return 0;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int getUsed() {
        return super.getItems().size();
    }
}
