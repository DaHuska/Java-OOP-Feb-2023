package com.company.InterfacesAndAbstraction._06_Ferrari;

public class Ferrari implements Car {
    private String driverName;
    private final String model = "488-Spider";

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    public String getModel() {
        return model;
    }

    public String getDriverName() {
        return driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }
}
