package org.kalbeka;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private final HashMap<Integer, String> numbersAndNames = new HashMap<>();

    public void add(int number, String name) {
        numbersAndNames.put(number, name);
    }

    public void get(String name) {

        if (numbersAndNames.containsValue(name)) {
            for (Map.Entry<Integer, String> temp : numbersAndNames.entrySet()) {
                if (temp.getValue().equals(name)) {
                    System.out.println(temp.getValue() + " : " + temp.getKey());
                }
            }
        } else {
            System.out.println("Имени нет в телефонной книге");
        }

    }

}
