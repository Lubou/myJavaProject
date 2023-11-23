package org.kalbeka;

public class Cat extends Animal {
    public static int catCount;

    public Cat(String name) {
        super(name);
        super.runLimit = 200;
        this.catCount++;
    }

    @Override
    void swim(int length) {
        System.out.println(getName() + " не умеет плавать, он кот");
    }
}
