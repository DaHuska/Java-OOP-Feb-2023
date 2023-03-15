package com.company.InterfacesAndAbstraction._01_CarShop;

public interface Car {
    int TIRES = 4;

    String getModel();
    String getColor();
    int getHorsePower();
    String countryProduced();
}