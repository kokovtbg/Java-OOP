package Exams.Exam16August2020.onlineShop.models.products.computers;

import Exams.Exam16August2020.onlineShop.models.products.Product;
import Exams.Exam16August2020.onlineShop.models.products.components.Component;
import Exams.Exam16August2020.onlineShop.models.products.peripherals.Peripheral;

import java.util.List;

public interface Computer extends Product {
    List<Component> getComponents();

    List<Peripheral> getPeripherals();

    void addComponent(Component component);

    Component removeComponent(String componentType);

    void addPeripheral(Peripheral peripheral);

    Peripheral removePeripheral(String peripheralType);
}