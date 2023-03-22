package com.company.Polymorphism._02_Shapes;

public abstract class Shape {
    private double perimeter;
    private double area;

    protected abstract void calculateArea();
    protected abstract void calculatePerimeter();

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
