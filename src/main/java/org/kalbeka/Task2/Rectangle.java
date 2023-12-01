package org.kalbeka.Task2;

public class Rectangle extends Shape implements Calculate {

    double a, b;

    public Rectangle(String borderColor, String bgColor, double a, double b) {
        super(borderColor, bgColor);
        this.a = a;
        this.b = b;
        this.perimeter = calculatePerimeter();
    }

    @Override
    public double calculatePerimeter() {
        return (2 * a) + (2 * b);
    };

    @Override
    public double calculateSquare() {
        square = a * b;
        return square;
    }

    @Override
    public void printInfo() {
        System.out.println("--------------------");
        System.out.println("Прямоугольник");
        System.out.println("Цвет границ - " + borderColor);
        System.out.println("Цвет заливки - " + bgColor);
        System.out.println("Периметр - " + perimeter);
        System.out.println("Площадь - " + calculateSquare());
    }
}
