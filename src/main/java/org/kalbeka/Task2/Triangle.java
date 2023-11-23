package org.kalbeka.Task2;

public class Triangle extends Shape implements Calculate {

    double a, b, c;

    public Triangle(String borderColor, String bgColor, double a, double b, double c) {
        super(borderColor, bgColor);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculatePerimeter() {
        super.perimeter = a + b + c;
        return super.perimeter;
    }

    @Override
    public double calculateSquare() {
        double p = calculatePerimeter();
        super.square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return super.square;
    }

    @Override
    public void printInfo() {
        System.out.println("--------------------");
        System.out.println("Треугольник");
        System.out.println("Цвет границ - " + borderColor);
        System.out.println("Цвет заливки - " + bgColor);
        System.out.println("Периметр - " + calculatePerimeter());
        System.out.println("Площадь - " + calculateSquare());
    }
}