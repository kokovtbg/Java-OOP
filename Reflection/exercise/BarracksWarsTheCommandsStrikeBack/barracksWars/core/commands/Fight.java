package Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.core.commands;

import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Fight extends Command {

    public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        return "fight";
    }
}
