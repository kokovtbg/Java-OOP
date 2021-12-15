package Exams.Exam22August2021.glacialExpedition.models.explorers;

import Exams.Exam22August2021.glacialExpedition.models.suitcases.Suitcase;

public class NaturalExplorer extends BaseExplorer {
    private static final int INITIAL_ENERGY = 60;
    private static final int ENERGY_DECREASE = 7;

    public NaturalExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void setEnergyDecrease(int energyDecrease) {
        super.setEnergyDecrease(ENERGY_DECREASE);
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public double getEnergy() {
        return super.energy;
    }

    @Override
    public Suitcase getSuitcase() {
        return super.suitcase;
    }

}
