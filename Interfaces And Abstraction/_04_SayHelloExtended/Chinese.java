package com.company.InterfacesAndAbstraction._04_SayHelloExtended;

public class Chinese extends BasePerson {
    protected Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
