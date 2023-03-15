package com.company.InterfacesAndAbstraction._01_CarShop;

import java.io.Serializable;

public class Seat implements Car, Serializable {
    private String model;
    private String color;
    private int horsePower;
    private String country;

    public Seat(String model, String color, int horsePower, String country) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.country = country;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String countryProduced() {
        return this.country;
    }


    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have 4 tires", getModel(), countryProduced());
    }
}
