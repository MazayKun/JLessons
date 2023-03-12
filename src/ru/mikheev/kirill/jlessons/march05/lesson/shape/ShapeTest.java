package ru.mikheev.kirill.jlessons.march05.lesson.shape;

import ru.mikheev.kirill.jlessons.march05.lesson.shape.hidden.CafeOrder;

public class ShapeTest {

    public static void main(String[] args) {

        System.out.println(
                new CafeOrder()
                        .addMainDish("Meat")
                        .addSalad("Cesar")
                        .addMainDish("Soup")
        );

    }
}
