package Polymorphism.exercise.Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {

    protected Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void drive(double kilometers) {
        if ((super.getFuelConsumption() + 0.9) * kilometers <= super.getFuelQuantity()) {
            super.setFuelQuantity(super.getFuelQuantity() - (super.getFuelConsumption() + 0.9) * kilometers);
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            System.out.println("Car travelled " + decimalFormat.format(kilometers) + " km");
        } else {
            System.out.println("Car needs refueling");
        }
    }

    @Override
    protected void refuel(double litters) {
        super.setFuelQuantity(super.getFuelQuantity() + litters);
    }
}
