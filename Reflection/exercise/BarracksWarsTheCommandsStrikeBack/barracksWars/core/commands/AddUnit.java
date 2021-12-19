package Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.core.commands;

import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Unit;
import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class AddUnit extends Command {

    public AddUnit(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = getData()[1];
        Unit unitToAdd = getUnitFactory().createUnit(unitType);
        getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
