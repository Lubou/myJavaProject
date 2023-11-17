package org.kalbeka;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println(task1(4, 5));
        task2("Hello", 3);
        task3(-7);
        System.out.println(task4(-8));
        System.out.println(task5(2024));
        task6();
        task7();
        task8();
        task9();
        System.out.println(Arrays.toString(task10(10, 5)));
    }

    // Задание 1
    private static boolean task1(int a, int b) {
        if (a + b >= 10 & a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    // Задание 2
    private static void task2(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    // Задание 3
    private static void task3(int c) {
        if (c >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    // Задание 4
    private static boolean task4(int d) {
        if (d >= 0) {
            return true;
        } else {
            return false;
        }
    }

    // Задание 5
    private static boolean task5(int y) {
        if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    // Задание 6
    private static void task6() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // Задание 7
    private static void task7() {
        int[] arr = new int[100];
        for (int i = 1; i <= 100; i++) {
            arr[i - 1] = i;
        }
        System.out.println(Arrays.toString(arr));
    }

    // Задание 8
    private static void task8() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // Задание 9
    private static void task9() {
        int[][] arr = new int[6][6];

        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr.length; x++) {
                if (x == y) {
                    arr[x][y] = 1;
                } else {
                    arr[x][y] = 0;
                }
                System.out.print(arr[y][x] + " ");
            }
            System.out.println();
        }
    }

    // Задание 10
    private static int[] task10(int len, int initialValue) {
        int[] x = new int[len];
        for (int i = 0; i < len; i++) {
            x[i] = initialValue;
        }
        return x;
    }
}