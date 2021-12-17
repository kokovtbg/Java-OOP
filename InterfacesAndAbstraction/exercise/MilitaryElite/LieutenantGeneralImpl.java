package InterfacesAndAbstraction.exercise.MilitaryElite;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Set<PrivateImpl> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new LinkedHashSet<>();
    }

    @Override
    public void addPrivate(PrivateImpl privat) {
        this.privates.add(privat);
    }

    public void sortPrivates() {
        this.privates = this.privates.stream().sorted((p1, p2) -> Integer.compare(p2.getId(), p1.getId())).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: " + this.getFirstName() + " " + this.getLastName() + " Id: " + this.getId() + " Salary: " + String.format("%.2f", this.getSalary()) + System.lineSeparator() + "Privates:" + System.lineSeparator());
        privates.forEach(p -> builder.append("  ").append(p).append(System.lineSeparator()));
        return builder.toString().trim();
    }
}
