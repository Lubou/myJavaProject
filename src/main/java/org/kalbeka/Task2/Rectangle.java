package org.kalbeka.Task2;

public class Rectangle extends Shape implements Calculate {

    double a, b;

    public Rectangle(String borderColor, String bgColor, double a, double b) {
        super(borderColor, bgColor);
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculatePerimeter() {
        super.perimeter = (2 * a) + (2 * b);
        return super.perimeter;
    }

    @Override
    public double calculateSquare() {
        super.square = a * b;
        return super.square;
    }

    @Override
    public void printInfo() {
        System.out.println("--------------------");
        System.out.println("Прямоугольник");
        System.out.println("Цвет границ - " + borderColor);
        System.out.println("Цвет заливки - " + bgColor);
        System.out.println("Периметр - " + calculatePerimeter());
        System.out.println("Площадь - " + calculateSquare());
    }
}
