package Polymorphism.exercise.VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Car car = null;
        Truck truck = null;
        Bus bus = null;
        for (int i = 0; i < 3; i++) {
            String[] vehicleInfo = scan.nextLine().split("\\s+");
            String vehicleType = vehicleInfo[0];
            double fuelQuantity = Double.parseDouble(vehicleInfo[1]);
            double fuelConsumption = Double.parseDouble(vehicleInfo[2]);
            double tankCapacity = Double.parseDouble(vehicleInfo[3]);

            switch (vehicleType) {
                case "Car":
                    car = new Car(fuelQuantity, fuelConsumption, tankCapacity);
                    break;
                case "Truck":
                    truck = new Truck(fuelQuantity, fuelConsumption, tankCapacity);
                    break;
                case "Bus":
                    bus = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
                    break;
            }
        }

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
                        case "Bus":
                            bus.drive(distance);
                            break;
                    }
                    break;
                case "Refuel":
                    try {
                        double liters = Double.parseDouble(commandParts[2]);
                        switch (typeVehicle) {
                            case "Car":
                                car.refuel(liters);
                                break;
                            case "Truck":
                                truck.refuel(liters);
                                break;
                            case "Bus":
                                bus.refuel(liters);
                                break;
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "DriveEmpty":
                    double distanceDriveEmpty = Double.parseDouble(commandParts[2]);
                    bus.driveEmpty(distanceDriveEmpty);
                    break;
            }
        }
        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f", bus.getFuelQuantity());
    }
}
