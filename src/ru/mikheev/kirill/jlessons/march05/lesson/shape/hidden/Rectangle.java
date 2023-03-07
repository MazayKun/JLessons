package ru.mikheev.kirill.jlessons.march05.lesson.shape.hidden;

public class Rectangle extends Shape {


    private Point leftUpCorner, rightDownCorner;

    Rectangle(Point leftUpCorner, Point rightDownCorner) {
        this.leftUpCorner = leftUpCorner;
        this.rightDownCorner = rightDownCorner;
    }

    @Override
    public double getArea() {
        return 10;
    }

    @Override
    public double getPerimeter() {
        return 20;
    }

    @Override
    public double getAngleCount() {
        return 4;
    }
}
