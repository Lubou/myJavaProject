package org.kalbeka.Task2;

public class Circle extends Shape implements Calculate {
    double r;

    public Circle(String borderColor, String bgColor, double r) {
        super(borderColor, bgColor);
        this.r = r;
    }

    @Override
    public double calculatePerimeter() {
        super.perimeter = Math.PI * 2 * r;
        return super.perimeter;
    }

    @Override
    public double calculateSquare() {
        super.square = Math.PI * (r * r);
        return super.square;
    }

    @Override
    public void printInfo() {
        System.out.println("--------------------");
        System.out.println("Круг");
        System.out.println("Цвет границ - " + borderColor);
        System.out.println("Цвет заливки - " + bgColor);
        System.out.println("Длина окружности - " + calculatePerimeter());
        System.out.println("Площадь - " + calculateSquare());
    }
}
