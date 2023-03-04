package ru.mikheev.kirill.jlessons.march05.lesson.shape;

public abstract class SelfDrawer {

    protected void drawLine(Point start, Point end) {
        System.out.println("Рисую линию - " + start + end);
    }

    protected abstract void drawSelf();
}
