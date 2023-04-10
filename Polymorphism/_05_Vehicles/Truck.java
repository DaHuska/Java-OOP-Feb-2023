package com.company.Polymorphism._05_Vehicles;

public class Truck extends Vehicle {
    private final double fuelConsumptionIncrease = 1.6;

    public Truck(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm);
        setFuelConsumption(litersPerKm + getFuelConsumptionIncrease());
    }

    @Override
    protected double refuel(double refuelQuantity) {
        double leakQuantity = refuelQuantity * 0.05;

        refuelQuantity -= leakQuantity;
        setFuelQuantity(getFuelQuantity() + refuelQuantity);

        return getFuelQuantity();
    }

    public double getFuelConsumptionIncrease() {
        return fuelConsumptionIncrease;
    }
}
