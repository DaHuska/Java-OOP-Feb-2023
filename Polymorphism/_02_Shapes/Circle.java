package com.company.Polymorphism._02_Shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculateArea() {
        double area = Math.PI * getRadius() * getRadius();

        setArea(area);
    }

    @Override
    protected void calculatePerimeter() {
        double perimeter = 2 * Math.PI * getRadius();

        setPerimeter(perimeter);
    }

    public final double getRadius() {
        return radius;
    }
}
