package org.kalbeka;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruitList;
    private double sumWeight;


    public Box() {
        this.fruitList = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruitList.add(fruit);
        sumWeight += fruit.getWeight();
    }

    public double getWeight() {
        return sumWeight;
    }

    /*public boolean compare() {
        if (new Box<Orange>().equals(new Box<Apple>()))

    }*/
}
