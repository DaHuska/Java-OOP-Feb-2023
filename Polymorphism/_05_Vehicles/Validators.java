package com.company.Polymorphism._05_Vehicles;

public class Validators {
    public static boolean canDrive(double distance, double fuelConsumption, double fuel) {
        double totalConsumption = distance * fuelConsumption;

        return fuel >= totalConsumption;
    }
}
