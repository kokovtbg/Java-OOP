package Polymorphism.exercise.Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] carInfo = scan.nextLine().split("\\s+");
        String[] truckInfo = scan.nextLine().split("\\s+");

        double fuelQuantityCar = Double.parseDouble(carInfo[1]);
        double fuelConsumptionCar = Double.parseDouble(carInfo[2]);
        Car car = new Car(fuelQuantityCar, fuelConsumptionCar);
        double fuelQuantityTruck = Double.parseDouble(truckInfo[1]);
        double fuelConsumptionTruck = Double.parseDouble(truckInfo[2]);
        Truck truck = new Truck(fuelQuantityTruck, fuelConsumptionTruck);

        int countCommands = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < countCommands; i++) {
            String[] commandParts = scan.nextLine().split("\\s+");
            String command = commandParts[0];
            String typeVehicle = commandParts[1];
            switch (command) {
                case "Drive":
                    double distance = Double.parseDouble(commandParts[2]);
                    switch (typeVehicle) {
                        case "Car":
                            car.drive(distance);
                            break;
                        case "Truck":
                            truck.drive(distance);
                            break;
                    }
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(commandParts[2]);
                    switch (typeVehicle) {
                        case "Car":
                            car.refuel(liters);
                            break;
                        case "Truck":
                            truck.refuel(liters);
                            break;
                    }
                    break;
            }
        }
        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f", truck.getFuelQuantity());
    }
}
