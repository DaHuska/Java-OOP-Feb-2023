package com.company.InterfacesAndAbstraction._09_BirthdayCelebrations;

public class Robot implements Identifiable, Birthable {
    private String id;
    private String model;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthDate() {
        return null;
    }
}
