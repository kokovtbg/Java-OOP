package InterfacesAndAbstraction.exercise.CollectionHierarchy;


public class AddRemoveCollection extends Collection implements AddRemovable {

    public AddRemoveCollection() {
        super();
    }

    @Override
    public String remove() {
        return super.getItems().remove(super.getItems().size() - 1);
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
}
