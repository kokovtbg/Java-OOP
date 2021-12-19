package Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.core.commands;

import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Executable;
import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return data;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }
}
