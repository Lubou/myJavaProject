package org.kalbeka.Task2;

public interface Calculate {
    default double calculatePerimeter() {
        return 0;
    }

    double calculateSquare();

    void printInfo();
}
