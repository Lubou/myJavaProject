package org.kalbeka;

/**
 * 1. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 * 2. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
 * поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * 3. Для хранения фруктов внутри коробки можно использовать ArrayList;
 * 4. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
 * вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 * 5. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
 * которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
 * Можно сравнивать коробки с яблоками и апельсинами;
 * 6. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов:
 * нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается,
 * а в другую перекидываются объекты, которые были в первой;
 * 7. Не забываем про метод добавления фрукта в коробку.
 */
public class App {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        //appleBox.addFruit(new Orange()); // -- Ошибка
        System.out.println("Вес коробки с яблоками " + appleBox.getWeight());

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.addFruit(new Orange());
        orangeBox1.addFruit(new Orange());
        //orangeBox.addFruit(new Apple()); // -- Ошибка
        System.out.println("Вес первой коробки с апельсинами " + orangeBox1.getWeight());

        Box<Orange> orangeBox2 = new Box<>();
        orangeBox2.addFruit(new Orange());
        System.out.println("Вес второй коробки с апельсинами " + orangeBox2.getWeight());

        System.out.println(appleBox.compare(orangeBox1));

        orangeBox1.transferFruits(orangeBox2);
        System.out.println(orangeBox2.getWeight());
        System.out.println(orangeBox1.getWeight());
    }
}
