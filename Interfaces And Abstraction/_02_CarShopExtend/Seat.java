package com.company.InterfacesAndAbstraction._02_CarShopExtend;

public class Seat extends CarImpl implements Sellable {
    private double price;

    public Seat(String model, String color, int horsePower, String country, double price) {
        super(model, color, horsePower, country);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s sells for %f", super.toString(), getModel(), getPrice());
    }
}
