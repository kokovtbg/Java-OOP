package Exams.Exam16August2020.onlineShop.models.products.computers;

import Exams.Exam16August2020.onlineShop.common.constants.ExceptionMessages;
import Exams.Exam16August2020.onlineShop.models.products.BaseProduct;
import Exams.Exam16August2020.onlineShop.models.products.components.Component;
import Exams.Exam16August2020.onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        if (components.contains(component)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_COMPONENT,
                    component.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        Component component = components.stream()
                .filter(c -> c.getClass().getSimpleName().equals(componentType))
                .findFirst().orElse(null);
        if (components.isEmpty() || component == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_COMPONENT,
                    componentType, this.getClass().getSimpleName(), this.getId()));
        }
        this.components.remove(component);
        return component;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (peripherals.contains(peripheral)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_PERIPHERAL,
                    peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        Peripheral peripheral = peripherals.stream()
                .filter(p -> p.getClass().getSimpleName().equals(peripheralType))
                .findFirst().orElse(null);
        if (peripherals.isEmpty() || peripheral == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_PERIPHERAL,
                    peripheralType, this.getClass().getSimpleName(), this.getId()));
        }
        this.peripherals.remove(peripheral);
        return peripheral;
    }

    @Override
    public double getOverallPerformance() {
        double overallPerformance = super.getOverallPerformance() + this.components.stream().mapToDouble(Component::getOverallPerformance).average().orElse(0.0);
        return overallPerformance;
    }

    @Override
    public double getPrice() {
        double price = super.getPrice() + this.components.stream().mapToDouble(Component::getPrice).sum()
                + this.peripherals.stream().mapToDouble(Peripheral::getPrice).sum();
        return price;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d)%n",
                getOverallPerformance(), getPrice(), this.getClass().getSimpleName(), getManufacturer(), getModel(), getId()));
        builder.append(String.format(" Components (%d):%n", this.components.size()));
        for (Component component : this.components) {
            builder.append(String.format("  %s%n", component));
        }
        builder.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f):%n",
                this.peripherals.size(), this.peripherals.stream().mapToDouble(Peripheral::getOverallPerformance).average().orElse(0.0)));
        for (Peripheral peripheral : this.peripherals) {
            builder.append(String.format("  %s%n", peripheral));
        }
        return builder.toString().trim();
    }
}
