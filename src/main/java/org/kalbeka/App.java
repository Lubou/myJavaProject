package org.kalbeka;

import java.util.*;

/* 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово. (реализовать с использованием коллекций)

2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.*/
public class App {
    public static void main(String[] args) {
        
        // Task 1

        String[] gr = {"Beatles", "Queen", "Metallica", "Aerosmith", "Beatles", "Ramones", "Nirvana", "Metallica",
                "Coldplay", "Beatles", "Radiohead", "Metallica", "Scorpions", "Beatles", "Slash", "Queen", "Offspring",
                "Beatles"};

        ArrayList<String> groups = new ArrayList<String>();
        Collections.addAll(groups, gr);

        Set<String> set = new LinkedHashSet<>(groups);
        System.out.println(set);

        Map<String, Integer> countGroups = new HashMap<>();

        for (String group : groups) {
            countGroups.put(group, countGroups.getOrDefault(group, 0) + 1);
        }
        System.out.println(countGroups);

        // Task 2

        Phonebook numbersAndNames = new Phonebook();
        numbersAndNames.add(408754, "Brian May");
        numbersAndNames.add(492834, "Jimi Hendrix");
        numbersAndNames.add(275474, "Jimmy Page");
        numbersAndNames.add(847598, "Brian May");
        numbersAndNames.add(408354, "Eric Clapton");
        numbersAndNames.add(725722, "David Gilmour");
        numbersAndNames.add(387368, "Jimi Hendrix");
        numbersAndNames.add(945898, "Eric Clapton");

        numbersAndNames.get("Brian May");
        numbersAndNames.get("Kurt Cobain");

    }
}

