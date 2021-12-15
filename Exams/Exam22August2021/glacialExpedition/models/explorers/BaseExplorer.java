package Exams.Exam22August2021.glacialExpedition.models.explorers;

import Exams.Exam22August2021.glacialExpedition.common.ExceptionMessages;
import Exams.Exam22August2021.glacialExpedition.models.suitcases.Carton;
import Exams.Exam22August2021.glacialExpedition.models.suitcases.Suitcase;

public abstract class BaseExplorer implements Explorer {
    protected String name;
    protected double energy;
    protected Suitcase suitcase;
    private int energyDecrease = 15;

    public BaseExplorer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        this.suitcase = new Carton();
    }

    public void setEnergyDecrease(int energyDecrease) {
        this.energyDecrease = energyDecrease;
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public Suitcase getSuitcase() {
        return suitcase;
    }

    public void search() {
        this.energy -= energyDecrease;
        if (this.energy < 0) {
            this.energy = 0;
        }
    }

    public boolean canSearch() {
        return this.energy > 0;
    }

}
