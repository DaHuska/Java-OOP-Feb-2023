package com.company.InterfacesAndAbstraction._02_CarShopExtend;

public class Audi extends CarImpl implements Rentable {
    private int minRentDay;
    private double pricePerDay;

    public Audi(String model, String color, int horsePower, String country, int minRentDay, double pricePerDay) {
        super(model, color, horsePower, country);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public int getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        return String.format("%s%nMinimum rental period is %d days. Price per day is %f", super.toString(), getMinRentDay(), getPricePerDay());
    }
}
