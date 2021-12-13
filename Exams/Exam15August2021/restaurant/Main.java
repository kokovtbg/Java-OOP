package Exams.Exam15August2021.restaurant;

import Exams.Exam15August2021.restaurant.repositories.interfaces.BeverageRepository;
import Exams.Exam15August2021.restaurant.repositories.interfaces.HealthFoodRepository;
import Exams.Exam15August2021.restaurant.repositories.interfaces.TableRepository;
import Exams.Exam15August2021.restaurant.core.ControllerImpl;
import Exams.Exam15August2021.restaurant.core.EngineImpl;
import Exams.Exam15August2021.restaurant.core.interfaces.Controller;
import Exams.Exam15August2021.restaurant.entities.drinks.interfaces.Beverages;
import Exams.Exam15August2021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import Exams.Exam15August2021.restaurant.entities.tables.interfaces.Table;

import Exams.Exam15August2021.restaurant.io.ConsoleReader;
import Exams.Exam15August2021.restaurant.io.ConsoleWriter;
import Exams.Exam15August2021.restaurant.repositories.BeverageRepositoryImpl;
import Exams.Exam15August2021.restaurant.repositories.HealthFoodRepositoryImpl;
import Exams.Exam15August2021.restaurant.repositories.TableRepositoryImpl;

public class Main {
    public static void main(String[] args) {

        HealthFoodRepository<HealthyFood> healthFoodRepository = new HealthFoodRepositoryImpl();
        BeverageRepository<Beverages> beverageRepository = new BeverageRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();

        Controller controller = new ControllerImpl(healthFoodRepository, beverageRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
    }
}
