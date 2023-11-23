package org.kalbeka;

/**
 * Hello world!
 */
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

class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public String toString() {
        return String.format("Имя: %s \tДолжность: %s \nEmail: %s \t Номер телефона: %s \n Зарплата: %d \t Возраст: %d \n",
                name, position, email, phone, salary, age);
    }

    public void printInfo() {
        System.out.println(this);
    }
}

/**
 * 3. Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию
 * об аттракционах, времени их работы и стоимости.
 **/
class Park {
    Attraction[] attractions = new Attraction[5];

    void addAtraction() {
        this.attractions[0] = new Attraction("Khali-Gali", "12.00-20.00", 19);
        this.attractions[1] = new Attraction("Paratruper", "14.00-19.00", 15);
        this.attractions[2] = new Attraction("Super-8", "13.00-20.00", 21);
    }

    class Attraction {
        String name;
        String time;
        int cost;

        Attraction(String name, String time, int cost) {
            this.name = name;
            this.time = time;
            this.cost = cost;
        }
    }
}