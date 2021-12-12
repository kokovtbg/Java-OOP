package Exams.Exam11December2021.catHouse.entities.houses;

import Exams.Exam11December2021.catHouse.common.ConstantMessages;
import Exams.Exam11December2021.catHouse.common.ExceptionMessages;
import Exams.Exam11December2021.catHouse.entities.cat.Cat;
import Exams.Exam11December2021.catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        return this.toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (this.cats.size() == capacity) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        this.cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
//        "{houseName} {houseType}:
//        Cats: {catName1} {catName2} {catName3} ... / Cats: none
//        Toys: {toysCount} Softness: {sumSoftness}"
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s %s:", this.name, this.getClass().getSimpleName()));
        builder.append(System.lineSeparator());
        builder.append("Cats: ");
        if (this.cats.isEmpty()) {
            builder.append("none");
        } else {
            builder.append(this.cats.stream().map(Cat::getName).collect(Collectors.joining(" ")));
//            for (Cat cat : this.cats) {
//                builder.append(cat.getName());
//                builder.append(" ");
//            }
        }
        builder.append(System.lineSeparator());
        builder.append(String.format("Toys: %d Softness: %d", this.toys.size(), this.sumSoftness()));
        return builder.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }
}
