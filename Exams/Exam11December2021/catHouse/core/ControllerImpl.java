package Exams.Exam11December2021.catHouse.core;

import Exams.Exam11December2021.catHouse.common.ConstantMessages;
import Exams.Exam11December2021.catHouse.common.ExceptionMessages;
import Exams.Exam11December2021.catHouse.entities.cat.Cat;
import Exams.Exam11December2021.catHouse.entities.cat.LonghairCat;
import Exams.Exam11December2021.catHouse.entities.cat.ShorthairCat;
import Exams.Exam11December2021.catHouse.entities.houses.House;
import Exams.Exam11December2021.catHouse.entities.houses.LongHouse;
import Exams.Exam11December2021.catHouse.entities.houses.ShortHouse;
import Exams.Exam11December2021.catHouse.entities.toys.Ball;
import Exams.Exam11December2021.catHouse.entities.toys.Mouse;
import Exams.Exam11December2021.catHouse.entities.toys.Toy;
import Exams.Exam11December2021.catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }
        this.houses.add(house);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }
        this.toys.buyToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }
        House house = this.houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);
        house.buyToy(toy);
        this.toys.removeToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }
        House house = this.houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);
        if ((cat.getClass().getSimpleName().startsWith("Short") && house.getClass().getSimpleName().startsWith("Short"))
        || (cat.getClass().getSimpleName().startsWith("Long") && house.getClass().getSimpleName().startsWith("Long"))) {
            house.addCat(cat);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
        }
        return ConstantMessages.UNSUITABLE_HOUSE;
    }

    @Override
    public String feedingCat(String houseName) {
        House house = this.houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);
        house.feeding();
        return String.format(ConstantMessages.FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = this.houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);
        double value = house.getCats().stream().mapToDouble(Cat::getPrice).sum() + house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        return String.format(ConstantMessages.VALUE_HOUSE, houseName, value);
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        for (House house : this.houses) {
            builder.append(house.getStatistics());
            builder.append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
