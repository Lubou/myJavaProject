package org.kalbeka;

public class App {
    /**
     * 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
     * Конструктор класса должен заполнять эти поля при создании объекта.
     * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
     * 2. Создать массив из 5 сотрудников.С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
     **/
    public static void main(String[] args) {
        Employee[] emplArray = new Employee[5];
        emplArray[0] = new Employee("Dwight Kurt Schrute III", "Salesman", "@gmail.com", "892312312", 30000, 41);
        emplArray[1] = new Employee("Michael Gary Scott", "Regional manager", "scott@gmail.com", "728638645", 70000, 58);
        emplArray[2] = new Employee("James Duncan Halpert", "Salesman", "Halpert@gmail.com", "7890679867", 15000, 36);
        emplArray[3] = new Employee("Pamela Morgan Halpert", "Receptionist", "pam@gmail.com", "84375987", 50000, 31);
        emplArray[4] = new Employee("Andrew Baines Bernard", "Salesman", "and@gmail.com", "94597957908", 30000, 35);
        for (int i = 0; i < emplArray.length; i++)
            if (emplArray[i].getAge() > 40) emplArray[i].printInfo();
    }
}