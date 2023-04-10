package com.company.Polymorphism._05_Vehicles;

public class Car extends Vehicle {
    private final double fuelConsumptionIncrease = 0.9;

    public Car(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm);
        setFuelConsumption(litersPerKm + fuelConsumptionIncrease);
    }

    @Override
    protected double refuel(double refuelQuantity) {
        setFuelQuantity(getFuelQuantity() + refuelQuantity);

        return getFuelQuantity();
    }
}
