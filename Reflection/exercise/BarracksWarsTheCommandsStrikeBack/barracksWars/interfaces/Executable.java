package Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface Executable {

	String execute() throws ExecutionControl.NotImplementedException;

}
