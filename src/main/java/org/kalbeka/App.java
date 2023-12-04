package org.kalbeka;

/* 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово. (реализовать с использованием коллекций)

2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.*/
public class App {
    public static void main(String[] args) {

        Array groups = new Array();
        groups.add("Beatles");
        groups.add("Queen");
        groups.add("Metallica");
        groups.add("Aerosmith");
        groups.add("Beatles");
        groups.add("Ramones");
        groups.add("Nirvana");
        groups.add("Metallica");
        groups.add("Coldplay");
        groups.add("Beatles");
        groups.add("Radiohead");
        groups.add("Metallica");
        groups.add("Scorpions");
        groups.add("Beatles");
        groups.add("Slash");
        groups.add("Queen");
        groups.add("Offspring");
        groups.add("Beatles");

        groups.get();

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

