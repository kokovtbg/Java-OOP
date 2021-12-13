package Exams.Exam12December2020.bakery;

import Exams.Exam12December2020.bakery.core.ControllerImpl;
import Exams.Exam12December2020.bakery.core.EngineImpl;
import Exams.Exam12December2020.bakery.repositories.interfaces.DrinkRepository;
import Exams.Exam12December2020.bakery.core.interfaces.Controller;
import Exams.Exam12December2020.bakery.repositories.DrinkRepositoryImpl;
import Exams.Exam12December2020.bakery.repositories.FoodRepositoryImpl;
import Exams.Exam12December2020.bakery.repositories.TableRepositoryImpl;
import Exams.Exam12December2020.bakery.repositories.entities.bakedFoods.interfaces.BakedFood;
import Exams.Exam12December2020.bakery.repositories.entities.drinks.interfaces.Drink;
import Exams.Exam12December2020.bakery.repositories.entities.tables.interfaces.Table;
import Exams.Exam12December2020.bakery.io.ConsoleReader;
import Exams.Exam12December2020.bakery.repositories.interfaces.FoodRepository;
import Exams.Exam12December2020.bakery.io.ConsoleWriter;
import Exams.Exam12December2020.bakery.repositories.interfaces.TableRepository;

public class Main {
    public static void main(String[] args) {

        FoodRepository<BakedFood> foodRepository = new FoodRepositoryImpl();
        DrinkRepository<Drink> drinkRepository = new DrinkRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();

        Controller controller = new ControllerImpl(foodRepository, drinkRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
