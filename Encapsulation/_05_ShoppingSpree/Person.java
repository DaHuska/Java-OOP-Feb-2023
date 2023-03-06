package com.company.Encapsulation._05_ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    public void buyProduct(Product product) {
        if (product.getCost() > this.money) {
            throw new IllegalStateException(String.format("%s can't afford %s", this.name, product.getName()));
        } else {
            System.out.printf("%s - %s%n", this.name, product.getName());
            this.products.add(product);

            this.money -= product.getCost();
        }
    }

    private void setName(String name) {
        if (!Validations.validateName(name)) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    private void setMoney(double money) {
        if (!Validations.validateMoney(money)) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }
}
