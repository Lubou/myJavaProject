package org.kalbeka;

import java.util.*;
import java.util.function.Predicate;

import java.util.stream.Stream;


//5. Нужно написать программу, которая будет принимать от пользователя ввод различных логинов.
// Как только пользователь введет пустую строку - программа должна прекратить приём данных от пользователя
// и вывести в консоль логины, начинающиеся на букву f (строчную).
public class Task5 {
    public static void checkLogin() {
        Scanner scanner = new Scanner(System.in);
        String log;
        ArrayList<String> logins = new ArrayList<>();
        System.out.println("Логин: ");
        while (true) {
            log = scanner.nextLine();
            if (log.isEmpty())
                break;
            logins.add(log);
        }

        Predicate<String> f = (str) -> {
            return str.charAt(0) == 'f';
        };

        Stream<String> stream = logins.stream();
        stream.filter(f).forEach(System.out::println);

    }

}
