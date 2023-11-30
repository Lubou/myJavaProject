package org.kalbeka;

/*Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException
и вывести результат расчета. */


public class App {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}};
        try {
            checkArray(arr);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Exception: " + e.getMessage());

        }
    }

    public static void checkArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int size = 4;

        int[][] num = new int[size][size];
        int sum = 0;

        if (arr.length != size) throw new MyArraySizeException("Некорректный размер массива");

        for (String[] strings : arr) {
            if (strings.length != size) throw new MyArraySizeException("Некорректный размер массива");
        }
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr.length; x++) {
                if (arr[y][x].matches("[-+]?\\d+")) {
                    num[y][x] = Integer.parseInt(arr[y][x]);
                    sum += Integer.parseInt(arr[y][x]);
                } else {
                    throw new MyArrayDataException(y, x);
                }
            }
        }

        System.out.println("Сумма = " + sum);
    }
}