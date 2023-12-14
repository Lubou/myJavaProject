package org.kalbeka;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruitList;
    private double sumWeight;

    public Box() {
        fruitList = new ArrayList<T>();
    }

    public void addFruit(T fruit) {
        fruitList.add(fruit);
        sumWeight += fruit.getWeight();
    }

    public double getWeight() {
        return sumWeight;
    }

    public boolean compare(Box<?> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.001;

    }

    public void transferFruits(Box<T> box) {
        for (T fruit : fruitList) {
            box.addFruit(fruit);
        }
        fruitList.clear();
        sumWeight = 0;
    }

}
