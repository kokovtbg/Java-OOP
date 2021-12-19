package Reflection.exercise.BarracksWarsANewFactory.barracksWars;

import Reflection.exercise.BarracksWarsANewFactory.barracksWars.interfaces.Repository;
import Reflection.exercise.BarracksWarsANewFactory.barracksWars.interfaces.Runnable;
import Reflection.exercise.BarracksWarsANewFactory.barracksWars.interfaces.UnitFactory;
import Reflection.exercise.BarracksWarsANewFactory.barracksWars.core.Engine;
import Reflection.exercise.BarracksWarsANewFactory.barracksWars.core.factories.UnitFactoryImpl;
import Reflection.exercise.BarracksWarsANewFactory.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
