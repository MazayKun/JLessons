package ru.mikheev.kirill.jlessons.march05.lesson.shape.hidden;

public interface SelfDrawer {


    default void drawLine(Point start, Point end) {
        System.out.println("Рисую линию - " + start + end);
    }

    void drawSelf();
}
