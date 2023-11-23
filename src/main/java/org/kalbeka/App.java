package org.kalbeka;

import org.kalbeka.Task2.Circle;
import org.kalbeka.Task2.Rectangle;
import org.kalbeka.Task2.Triangle;

//Задание 1
// Создать классы Собака и Кот с наследованием от класса Животное.
//Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
// Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//Добавить подсчет созданных котов, собак и животных.
//Расширить задачу про котов и тарелки с едой.
//        2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
//        (например, в миске 10 еды, а кот пытается покушать 15-20).
//        3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту
//        удалось покушать (хватило еды), сытость = true.
//        4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть
//        наполовину сыт (это сделано для упрощения логики программы).
//        5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
//        потом вывести информацию о сытости котов в консоль.
//        6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
public class App {
    static Cat[] cats = new Cat[3];
    static Plate plate = new Plate(30);

    public static void main(String[] args) {

        Dog dog = new Dog("Бобик");
        Cat tom = new Cat("Том", 15, false);
        Cat barsik = new Cat("Барсик", 20, false);
        Cat murzik = new Cat("Мурзик", 15, false);

        cats[0] = tom;
        cats[1] = barsik;
        cats[2] = murzik;


        dog.run(600);
        tom.run(150);
        barsik.run(100);
        dog.swim(15);
        tom.swim(20);
        barsik.swim(5);

        // Перекус
        System.out.println("-------Перекус--------");
        for (int i = 0; i < cats.length; i++) {
            eat(cats[i]);
        }

        // Добавляем в тарелку 30 еды
        plate.increaseFood(30);
        plate.getFoodCount();

        // Счетчик
        System.out.println("-------------------------");
        System.out.println("Количество животных - " + Animal.animalCount);
        System.out.println("Количество собак - " + Dog.dogCount);
        System.out.println("Количество котов - " + Cat.catCount);

        // Task 2 Применяя интерфейсы написать программу расчета периметра и площади
        // геометрических фигур: круг, прямоугольник, треугольник.
        //Задать для каждой фигуры цвет заливки и цвет границы.
        //Результат полученных характеристик [ Периметр, площадь, цвет фона, цвет границ ]
        // по каждой фигуре вывести в консоль.
        
        Triangle triangle = new Triangle("black", "white", 3, 2, 3);
        Circle circle = new Circle("red", "yellow", 10);
        Rectangle rectangle = new Rectangle("blue", "brown", 5, 7);

        triangle.printInfo();
        circle.printInfo();
        rectangle.printInfo();
    }


    private static void eat(Cat cat) {
        if (cat.full == false && cat.needToEat <= plate.food) {
            cat.eat(plate);
            cat.full = true;
            System.out.println(cat.name + " поел!");
        } else {
            System.out.println(cat.name + " не поел!");
        }
    }
}