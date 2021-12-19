package Reflection.exercise.BarracksWarsANewFactory.barracksWars.models.units;

public class Gunner extends AbstractUnit {
    private final static int GUNNER_HEALTH = 20;
    private final static int GUNNER_DAMAGE = 20;

    public Gunner() {
        super(GUNNER_HEALTH, GUNNER_DAMAGE);
    }
}
