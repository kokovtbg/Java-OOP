package Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars;

import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Runnable;
import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;
import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.core.Engine;
import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.core.factories.UnitFactoryImpl;
import Reflection.exercise.BarracksWarsTheCommandsStrikeBack.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
