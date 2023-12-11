package org.kalbeka;

public abstract class Fruit {
    private double weight;
    private String fruitName;

    public Fruit(String fruitName, double weight) {
        this.fruitName = fruitName;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return fruitName;
    }

}
