package Polymorphism.exercise.VehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void drive(double kilometers) {
        if ((super.getFuelConsumption() + 1.4) * kilometers <= super.getFuelQuantity()) {
            super.setFuelQuantity(super.getFuelQuantity() - (super.getFuelConsumption() + 1.4) * kilometers);
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            System.out.println("Bus travelled " + decimalFormat.format(kilometers) + " km");
        } else {
            System.out.println("Bus needs refueling");
        }
    }

    protected void driveEmpty(double kilometers) {
        if ((super.getFuelConsumption()) * kilometers <= super.getFuelQuantity()) {
            super.setFuelQuantity(super.getFuelQuantity() - (super.getFuelConsumption()) * kilometers);
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            System.out.println("Bus travelled " + decimalFormat.format(kilometers) + " km");
        } else {
            System.out.println("Bus needs refueling");
        }
    }

    @Override
    protected void refuel(double litters) {
        if (litters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (super.getFuelQuantity() + litters <= super.getTankCapacity()) {
            super.setTankCapacity(super.getFuelQuantity() + litters);
        } else {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }
}
