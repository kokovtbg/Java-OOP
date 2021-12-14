package Exams.Exam18April2021.spaceStation.models.astronauts;

import Exams.Exam18April2021.spaceStation.common.ConstantMessages;
import Exams.Exam18April2021.spaceStation.common.ExceptionMessages;
import Exams.Exam18April2021.spaceStation.models.bags.Backpack;
import Exams.Exam18April2021.spaceStation.models.bags.Bag;

public abstract class BaseAstronaut implements Astronaut {
    private static final int DEFAULT_OXYGEN_CONSUMPTION = 10;
    private String name;
    private double oxygen;
    private Bag bag;

    public BaseAstronaut(String name, double oxygen) {
        setName(name);
        setOxygen(oxygen);
        this.bag = new Backpack();
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    @Override
    public boolean canBreath() {
        return oxygen - DEFAULT_OXYGEN_CONSUMPTION >= 0;
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    @Override
    public void breath() {
        oxygen -= DEFAULT_OXYGEN_CONSUMPTION;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, this.name));
        builder.append(System.lineSeparator());
        builder.append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, this.oxygen));
        builder.append(System.lineSeparator());
        if (this.bag.getItems().isEmpty()) {
            builder.append("Bag items: none");
        } else {
            builder.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, this.bag.getItems())));
        }

        return builder.toString().trim();
    }
}
