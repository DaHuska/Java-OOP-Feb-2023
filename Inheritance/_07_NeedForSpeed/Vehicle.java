package com.company.Inheritance._07_NeedForSpeed;

public class Vehicle {
    private static final double DEFAULT_FUEL_CONSUMPTION =  1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    public void drive(double kilometers) {
        double fuelToConsume = getFuelConsumption() * kilometers;

        if (fuelToConsume > getFuel()) {
            throw new IllegalStateException(String.format("Not enough fuel to drive %.2f kilometers with %.2f consumption", kilometers, getFuelConsumption()));
        }

        setFuel(getFuel() - fuelToConsume);
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
