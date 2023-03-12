package ru.mikheev.kirill.jlessons.march05.lesson.shape.hidden;

import java.io.IOException;

public class MyCustomShapeException extends IOException {
    @Override
    public void printStackTrace() {
        System.out.println("Hello");
    }
}
