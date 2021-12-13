package Exams.Exam12December2020.bakery.repositories.entities.tables.interfaces;

import Exams.Exam12December2020.bakery.repositories.entities.bakedFoods.interfaces.BakedFood;
import Exams.Exam12December2020.bakery.repositories.entities.drinks.interfaces.Drink;

public interface Table {
    int getTableNumber();

    int getCapacity();

    int getNumberOfPeople();

    double getPricePerPerson();

    boolean isReserved();

    double getPrice();

    void reserve(int numberOfPeople);

    void orderFood(BakedFood food);

    void orderDrink(Drink drink);

    double getBill();

    void clear();

    String getFreeTableInfo();
}
