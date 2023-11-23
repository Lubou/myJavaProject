package org.kalbeka;

public class Plate {
    public int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int eat) {
        food = food - eat;
    }

    public void increaseFood(int eat) {
        food = food + eat;
    }

    public void getFoodCount() {
        System.out.println("Еды в тарелке: " + food);
    }
}
