package com.company.InterfacesAndAbstraction._02_CarShopExtend;

import java.io.Serializable;

public class CarImpl implements Car, Serializable {
    private String model;
    private String color;
    private int horsePower;
    private String country;

    public CarImpl(String model, String color, int horsePower, String country) {
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
