package org.kalbeka;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        printTheeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    private static void printTheeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    private static void checkSumSign() {
        int a = 2;
        int b = -2;
        int sum = a+b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }

    private static void printColor() {
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        }
        else if (value <= 100) {
            System.out.println("Желтый");
        }
        else {
            System.out.println("Зеленый");
        }
    }

    private static void compareNumbers() {
        int a = 4;
        int b = 7;
        if (a >= b) {
            System.out.println("a >= b");
        }
        else {
            System.out.println("a < b");
        }
    }
}
