package com.company.Encapsulation._02_SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        this.salary = calculateSalary(bonus);
    }

    private double calculateSalary(double bonus) {
        if (this.getAge() < 30) {
            bonus /= 2;
        }

        return this.getSalary() + (this.getSalary() * (bonus / 100));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva", this.firstName, this.lastName, this.salary); // didnt format the decimals after ',' for the salary
    }
}
