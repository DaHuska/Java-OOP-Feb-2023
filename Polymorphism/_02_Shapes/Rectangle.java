package com.company.Polymorphism._02_Shapes;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void calculateArea() {
        double area = getHeight() * getWidth();

        setArea(area);
    }

    @Override
    public void calculatePerimeter() {
        double perimeter = 2 * getWidth() + 2 * getHeight();

        setPerimeter(perimeter);
    }

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }
}
