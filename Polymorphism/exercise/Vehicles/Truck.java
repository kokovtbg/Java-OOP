package Polymorphism.exercise.Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {

    protected Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void drive(double kilometers) {
        if ((super.getFuelConsumption() + 1.6) * kilometers <= super.getFuelQuantity()) {
            super.setFuelQuantity(super.getFuelQuantity() - (super.getFuelConsumption() + 1.6) * kilometers);
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            System.out.println("Truck travelled " + decimalFormat.format(kilometers) + " km");
        } else {
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    protected void refuel(double litters) {
        super.setFuelQuantity(super.getFuelQuantity() + 0.95 * litters);
    }
}
