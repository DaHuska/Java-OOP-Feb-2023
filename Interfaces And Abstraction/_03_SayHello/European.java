package com.company.InterfacesAndAbstraction._03_SayHello;

public class European implements Person {
    private String name;

    public European(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return null; // not needed
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}