package org.kalbeka;

public class Dog extends Animal {

    public static int dogCount;
    public Dog(String name) {
        super(name);
        super.runLimit = 500;
        super.swimLimit = 10;
        this.dogCount++;
    }
}
