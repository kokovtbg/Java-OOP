package Exams.Exam15August2021.restaurant.entities.tables;

import Exams.Exam15August2021.restaurant.common.ExceptionMessages;
import Exams.Exam15August2021.restaurant.entities.drinks.interfaces.Beverages;
import Exams.Exam15August2021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import Exams.Exam15August2021.restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    protected BaseTable(int number, int size, double pricePerPerson) {
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.number = number;
        setSize(size);
        this.pricePerPerson = pricePerPerson;
    }

    private void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
        isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double foodBill = healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        double beverageBill = beverages.stream().mapToDouble(Beverages::getPrice).sum();
        return foodBill + beverageBill + numberOfPeople * pricePerPerson;
    }

    @Override
    public void clear() {
        this.isReservedTable = false;
        numberOfPeople = 0;
        this.healthyFood.clear();
        this.beverages.clear();
    }

    @Override
    public String tableInformation() {
        return String.format("Table - %d%n" +
                "Size - %d%n" +
                "Type - %s%n" +
                "All price - %.2f",
                this.number, this.size, this.getClass().getSimpleName(), this.pricePerPerson
        );
    }
}
