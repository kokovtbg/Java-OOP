package InterfacesAndAbstraction.exercise.MilitaryElite;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Set<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    public Collection<Repair> getRepairs() {
        return this.repairs;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: ").append(this.getFirstName()).append(" ").append(this.getLastName()).append(" Id: ").append(this.getId()).append(" Salary: ").append(String.format("%.2f", this.getSalary())).append(System.lineSeparator());
        builder.append("Corps: ").append(this.getCorps()).append(System.lineSeparator());
        builder.append("Repairs:").append(System.lineSeparator());
        repairs.forEach(r -> builder.append("  ").append(r).append(System.lineSeparator()));

        return builder.toString().trim();
    }
}
