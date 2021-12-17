package InterfacesAndAbstraction.exercise.MilitaryElite;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private String corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        validateCorps(corps);
    }

    public void validateCorps(String corps) {
        if (!corps.equals(Corps.AIR_FORCES.getValue()) && !corps.equals(Corps.MARINES.getValue())) {
            throw new IllegalArgumentException("Corps must be Air_Force or Marines");
        }
        this.corps = corps;
    }

    public String getCorps() {
        return corps;
    }
}
