package org.kalbeka;

import java.util.*;

//2. Задана коллекция, состоящая из строк: «Highload», «High», «Load», «Highload». Нужно с ней выполнить следующие манипуляции:
//2.1. Посчитать, сколько раз объект «High» встречается в коллекции;
//2.2. Определить, какой элемент в коллекции находится на первом месте. Если мы получили пустую коллекцию, то пусть возвращается 0;
//2.3. Необходимо вернуть последний элемент, если получили пустую коллекцию, то пусть возвращается 0;
public class Task2 {
    public static void checkHigh() {
        final List<String> high = Arrays.asList("Highload", "High", "Load", "Highload");

        int a = (int) high.stream().filter("High"::equals).count();
        System.out.println("Oбъект «High» встречается в коллекции " + a + " раз");

        String b = (String) high.stream().findFirst().orElse("0");
        System.out.println("элемент " + b + " в коллекции находится на первом месте");

        String c = (String) high.stream().skip(high.size() - 1).findFirst().orElse("0");
        System.out.println("последний элемент - " + c);
    }

}