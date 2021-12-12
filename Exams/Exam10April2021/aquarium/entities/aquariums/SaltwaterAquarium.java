package Exams.Exam10April2021.aquarium.entities.aquariums;

public class SaltwaterAquarium extends BaseAquarium {
    protected static final int CAPACITY = 25;

    public SaltwaterAquarium(String name) {
        super(name, CAPACITY);
    }
}
