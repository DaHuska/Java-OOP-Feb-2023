package com.company.Polymorphism._05_Vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
    }

    protected abstract double refuel(double refuelQuantity);
    protected double drive(double distance) {
        if (!Validators.canDrive(distance, getFuelConsumption(), getFuelQuantity())) {
            throw new IllegalStateException(String.format("%s needs refueling", this.getClass().getSimpleName()));
        }

        double fuelConsumed = distance * getFuelConsumption();
        setFuelQuantity(getFuelQuantity() - fuelConsumed);

        return distance;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    protected double getFuelConsumption() {
        return fuelConsumption;
    }
}
