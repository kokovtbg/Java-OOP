package Exams.Exam22August2021.glacialExpedition.models.explorers;

import Exams.Exam22August2021.glacialExpedition.models.suitcases.Suitcase;

public class AnimalExplorer extends BaseExplorer {
    private static final int INITIAL_ENERGY = 100;

    public AnimalExplorer(String name) {
        super(name, INITIAL_ENERGY);
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
