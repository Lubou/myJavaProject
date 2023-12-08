package org.kalbeka;

import java.util.*;

//1. Для любого набора случайно-сгенерированных чисел нужно определить количество чётных чисел.
public class Task1 {
    public static void checkNum() {
        ArrayList<Integer> numbers = new ArrayList<>();
        int numb;
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            numb = rand.nextInt() % 100;
            numbers.add(numb);
        }
        System.out.println("Случайный набор чисел: " + numbers);

        int evenum = (int) (numbers.stream().filter((n) -> (n % 2) == 0)).count();
        System.out.println("Количество четных чисел = " + evenum);

    }
}
