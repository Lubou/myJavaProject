package org.kalbeka;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Phonebook {
    private final HashMap<Integer, String> numbersAndNames = new HashMap<>();

    public void add(int number, String name) {
        numbersAndNames.put(number, name);
    }

    public void get(String name) {

        if (numbersAndNames.containsValue(name)) {
            Set<Map.Entry<Integer, String>> set = numbersAndNames.entrySet();
            for (Map.Entry<Integer, String> temp : set) {
                if (temp.getValue().equals(name)) {
                    System.out.println(temp.getValue() + " : " + temp.getKey());
                }
            }
        } else {
            System.out.println("Имени нет в телефонной книге");
        }

    }

}
