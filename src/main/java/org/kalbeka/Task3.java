package org.kalbeka;

import java.util.*;

//3. Задана коллекция, содержащая элементы "f10", "f15", "f2", "f4", "f4".
// Необходимо отсортировать строки по возрастанию и добавить их в массив;
public class Task3 {
    public static void checkF() {

        List<String> f = new ArrayList<>(List.of("f15", "f10", "f2", "f4", "f4"));

        f.sort(Comparator.comparingInt(s -> Integer.parseInt(s.substring(1))));

        System.out.println(f);

    }

}