package org.kalbeka;

public class MyArrayDataException extends Exception {

    public MyArrayDataException(int y, int x) {
        super(String.format(String.format("Ошибка в ячейке (%d, %d)", y + 1, x + 1)));
    }
}
