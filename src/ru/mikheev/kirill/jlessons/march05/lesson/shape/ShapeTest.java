package ru.mikheev.kirill.jlessons.march05.lesson.shape;

import ru.mikheev.kirill.jlessons.march05.lesson.shape.hidden.Rectangle;
import ru.mikheev.kirill.jlessons.march05.lesson.shape.hidden.ShapeFactory;

public class ShapeTest {

    public static void main(String[] args) {
        Rectangle rectangle = ShapeFactory.createRectangle(1.0, 1.0, 2.0, 2.0);
    }
}
