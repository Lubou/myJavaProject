package org.kalbeka;

public class Animal {
    String name;
    int runLimit;
    int swimLimit;
    public static int animalCount;

    public String getName() {
        return name;
    }

    public Animal(String name) {
        this.animalCount++;
        this.name = name;
    }

    static int count = 0;

    public void run(int length) {
        if (runLimit > length & length > 0) {
            System.out.println(name + " пробежал " + length + "м");
        } else {
            System.out.println(name + " не может пробежать: " + length + "м");
        }
    }

    void swim(int length) {
        if (swimLimit > length & length > 0) {
            System.out.println(name + " проплыл " + length + "м");
        } else {
            System.out.println(name + " не может проплыть " + length + "м");
        }
    }
}
