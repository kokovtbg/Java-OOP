package Reflection.exercise.BarracksWarsANewFactory.barracksWars.core.factories;

import Reflection.exercise.BarracksWarsANewFactory.barracksWars.interfaces.Unit;
import Reflection.exercise.BarracksWarsANewFactory.barracksWars.interfaces.UnitFactory;
import Reflection.exercise.BarracksWarsANewFactory.barracksWars.models.units.*;
import jdk.jshell.spi.ExecutionControl;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		// TODO: implement for problem 3
		switch (unitType) {
			case "Archer":
				return new Archer();
			case "Gunner":
				return new Gunner();
			case "Horseman":
				return new Horseman();
			case "Pikeman":
				return new Pikeman();
			case "Swordsman":
				return new Swordsman();
			default:
				throw new ExecutionControl.NotImplementedException("message");
		}
	}
}
