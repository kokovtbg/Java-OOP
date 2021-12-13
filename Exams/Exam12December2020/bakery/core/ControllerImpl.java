package Exams.Exam12December2020.bakery.core;

import Exams.Exam12December2020.bakery.common.ExceptionMessages;
import Exams.Exam12December2020.bakery.common.OutputMessages;
import Exams.Exam12December2020.bakery.core.interfaces.Controller;
import Exams.Exam12December2020.bakery.repositories.entities.bakedFoods.interfaces.BakedFood;
import Exams.Exam12December2020.bakery.repositories.entities.bakedFoods.Bread;
import Exams.Exam12December2020.bakery.repositories.entities.bakedFoods.Cake;
import Exams.Exam12December2020.bakery.repositories.entities.drinks.interfaces.Drink;
import Exams.Exam12December2020.bakery.repositories.entities.drinks.Tea;
import Exams.Exam12December2020.bakery.repositories.entities.drinks.Water;
import Exams.Exam12December2020.bakery.repositories.entities.tables.InsideTable;
import Exams.Exam12December2020.bakery.repositories.entities.tables.OutsideTable;
import Exams.Exam12December2020.bakery.repositories.entities.tables.interfaces.Table;
import Exams.Exam12December2020.bakery.repositories.interfaces.DrinkRepository;
import Exams.Exam12December2020.bakery.repositories.interfaces.FoodRepository;
import Exams.Exam12December2020.bakery.repositories.interfaces.TableRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private static double totalBills;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
        totalBills = 0;
    }

    @Override
    public String addFood(String type, String name, double price) {
        BakedFood food = foodRepository.getByName(name);
        if (food != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }
        switch (type) {
            case "Bread":
                food = new Bread(name, price);
                break;
            case "Cake":
                food = new Cake(name, price);
                break;
        }
        foodRepository.add(food);
        return String.format(OutputMessages.FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Drink drink = drinkRepository.getByNameAndBrand(name, brand);
        if (drink != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }
        switch (type) {
            case "Tea":
                drink = new Tea(name, portion, brand);
                break;
            case "Water":
                drink = new Water(name, portion, brand);
                break;
        }
        drinkRepository.add(drink);
        return String.format(OutputMessages.DRINK_ADDED, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = tableRepository.getByNumber(tableNumber);
        if (table != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_EXIST, tableNumber));
        }
        switch (type) {
            case "InsideTable":
                table = new InsideTable(tableNumber, capacity);
                break;
            case "OutsideTable":
                table = new OutsideTable(tableNumber, capacity);
                break;
        }
        tableRepository.add(table);
        return String.format(OutputMessages.TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        for (Table table : tableRepository.getAll()) {
            if (!table.isReserved() && table.getCapacity() >= numberOfPeople) {
                table.reserve(numberOfPeople);
                return String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
            }
        }
        return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table tableInRepo = tableRepository.getByNumber(tableNumber);
        if (tableInRepo == null || !tableInRepo.isReserved()) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }
        BakedFood foodInRepo = foodRepository.getByName(foodName);
        if (foodInRepo == null) {
            return String.format(OutputMessages.NONE_EXISTENT_FOOD, foodName);
        }
        tableInRepo.orderFood(foodInRepo);
        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Table tableInRepo = tableRepository.getByNumber(tableNumber);
        if (tableInRepo == null || !tableInRepo.isReserved()) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }
        Drink drinkInRepo = drinkRepository.getByNameAndBrand(drinkName, drinkBrand);
        if (drinkInRepo == null) {
            return String.format(OutputMessages.NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }
        tableInRepo.orderDrink(drinkInRepo);
        return String.format(OutputMessages.DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);
    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table = tableRepository.getByNumber(tableNumber);
        double bill = table.getBill();
        totalBills += table.getBill();
        table.clear();
        return String.format(OutputMessages.BILL, tableNumber, bill);
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder builder = new StringBuilder();
        List<Table> freeTables = tableRepository.getAll().stream()
                .filter(t -> !t.isReserved()).collect(Collectors.toList());
        for (Table table : freeTables) {
            builder.append(table.getFreeTableInfo());
            builder.append(System.lineSeparator());
        }
        return builder.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format(OutputMessages.TOTAL_INCOME, totalBills);
    }
}
