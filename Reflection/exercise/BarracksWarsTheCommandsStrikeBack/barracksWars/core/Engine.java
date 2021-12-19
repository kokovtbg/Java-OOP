package Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.core;

import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.core.commands.AddUnit;
import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.core.commands.Fight;
import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.core.commands.Report;
import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.core.commands.Retire;
import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Runnable;
import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				String input = scanner.nextLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException | ExecutionControl.NotImplementedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// TODO: refactor for problem 4
	private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
		String result;
		switch (commandName) {
			case "add":
				result = (new AddUnit(data, this.repository, this.unitFactory)).execute();
				break;
			case "report":
				result = (new Report(data, this.repository, this.unitFactory)).execute();
				break;
			case "fight":
				result = (new Fight(data, this.repository, this.unitFactory)).execute();
				break;
			case "retire":
				result = "";
				(new Retire(data, this.repository, this.unitFactory)).execute();
				break;
			default:
				throw new RuntimeException("Invalid command!");
		}
		return result;
	}
}
