package Exams.Exam16August2020.onlineShop.core;

import Exams.Exam16August2020.onlineShop.common.constants.ExceptionMessages;
import Exams.Exam16August2020.onlineShop.common.constants.OutputMessages;
import Exams.Exam16August2020.onlineShop.models.products.components.*;
import Exams.Exam16August2020.onlineShop.models.products.peripherals.*;
import Exams.Exam16August2020.onlineShop.core.interfaces.Controller;
import Exams.Exam16August2020.onlineShop.models.products.computers.Computer;
import Exams.Exam16August2020.onlineShop.models.products.computers.DesktopComputer;
import Exams.Exam16August2020.onlineShop.models.products.computers.Laptop;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {
    private List<Computer> computers;
    private List<Component> components;
    private List<Peripheral> peripherals;

    public ControllerImpl() {
        this.computers = new ArrayList<>();
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        Computer computer = computers.stream().filter(c -> c.getId() == id).findAny().orElse(null);
        if (computer != null) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
        }
        switch (computerType) {
            case "DesktopComputer":
                computer = new DesktopComputer(id, manufacturer, model, price);
                break;
            case "Laptop":
                computer = new Laptop(id, manufacturer, model, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPUTER_TYPE);
        }
        this.computers.add(computer);
        return String.format(OutputMessages.ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        Computer computer = computers.stream().filter(c -> c.getId() == computerId).findAny().orElse(null);
        if (computer == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        Peripheral peripheral = peripherals.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        if (peripheral != null) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_PERIPHERAL_ID);
        }
        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PERIPHERAL_TYPE);
        }
        computer.addPeripheral(peripheral);
        this.peripherals.add(peripheral);
        return String.format(OutputMessages.ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        Computer computer = computers.stream().filter(c -> c.getId() == computerId).findAny().orElse(null);
        if (computer == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        int peripheralId = computer.getComponents().stream()
                .filter(p -> p.getClass().getSimpleName().equals(peripheralType))
                .mapToInt(Component::getId)
                .findFirst().orElse(0);
        computer.removePeripheral(peripheralType);
        Peripheral peripheral = this.peripherals.stream().filter(p -> p.getId() == peripheralId).findFirst().orElse(null);
        this.peripherals.remove(peripheral);
        return String.format(OutputMessages.REMOVED_PERIPHERAL, peripheralType, peripheralId);
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        Computer computer = computers.stream().filter(c -> c.getId() == computerId).findAny().orElse(null);
        if (computer == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        Component component = components.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        if (component != null) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPONENT_ID);
        }
        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
        }
        computer.addComponent(component);
        this.components.add(component);
        return String.format(OutputMessages.ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        Computer computer = computers.stream().filter(c -> c.getId() == computerId).findAny().orElse(null);
        if (computer == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        int componentId = computer.getComponents().stream()
                .filter(c -> c.getClass().getSimpleName().equals(componentType))
                .mapToInt(Component::getId)
                .findFirst().orElse(0);
        computer.removeComponent(componentType);
        Component component = this.components.stream().filter(c -> c.getId() == componentId).findFirst().orElse(null);
        this.components.remove(component);
        return String.format(OutputMessages.REMOVED_COMPONENT, componentType, componentId);
    }

    @Override
    public String buyComputer(int id) {
        Computer computer = computers.stream().filter(c -> c.getId() == id).findAny().orElse(null);
        if (computer == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        this.computers.remove(computer);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        Computer bestComputer = computers.stream()
                .sorted((c1, c2) -> Double.compare(c2.getOverallPerformance(), c1.getOverallPerformance()))
                .filter(c -> c.getPrice() <= budget).findAny().orElse(null);
        if (bestComputer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAN_NOT_BUY_COMPUTER, budget));
        }
        return bestComputer.toString();
    }

    @Override
    public String getComputerData(int id) {
        Computer computer = computers.stream().filter(c -> c.getId() == id).findAny().orElse(null);
        if (computer == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }

        return computer.toString();
    }
}
