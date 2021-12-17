package InterfacesAndAbstraction.exercise.CollectionHierarchy;


public class AddCollection extends Collection implements Addable {

    public AddCollection() {
        super();
    }

    @Override
    public int add(String element) {
        if (super.getItems().size() < getMaxSize()) {
            super.getItems().add(element);
            return super.getItems().size() - 1;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
