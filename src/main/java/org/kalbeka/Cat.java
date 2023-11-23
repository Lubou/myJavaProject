package org.kalbeka;

public class Cat extends Animal {
    public static int catCount;
    public int needToEat;
    public boolean full;

    public Cat(String name, int needToEat, boolean full) {
        super(name);
        super.runLimit = 200;
        this.catCount++;
        this.needToEat = needToEat;
        this.full = full;
    }

    @Override
    void swim(int length) {
        System.out.println(getName() + " не умеет плавать, он кот");
    }

    public void eat(Plate plate) {
        plate.decreaseFood(needToEat);
    }
}
