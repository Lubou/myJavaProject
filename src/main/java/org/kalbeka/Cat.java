package org.kalbeka;

public class Cat extends Animal {
    private static int catCount;
    private final int needToEat;
    private boolean full;

    public Cat(String name, int needToEat, boolean full) {
        super(name);
        super.runLimit = 200;
        catCount++;
        this.needToEat = needToEat;
        this.full = full;
    }

    public boolean getFull() {
        return full;
    }

    public void setFull(boolean isFull) {
        this.full = isFull;
    }

    public int getNeedToEat() {
        return needToEat;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    void swim(int length) {
        System.out.println(getName() + " не умеет плавать, он кот");
    }

    public void eat(Plate plate) {
        if (!this.getFull() && this.getNeedToEat() <= plate.food) {
            plate.decreaseFood(needToEat);
            this.setFull(true);
            System.out.println(this.name + " поел!");
        } else {
            System.out.println(this.name + " не поел!");
        }
    }
}
