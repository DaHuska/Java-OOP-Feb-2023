package com.company.InterfacesAndAbstraction._03_SayHello;

public class Bulgarian implements Person {
    private String name;

    public Bulgarian(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return null; // not needed
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
