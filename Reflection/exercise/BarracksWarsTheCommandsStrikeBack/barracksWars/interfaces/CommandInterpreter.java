package Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
