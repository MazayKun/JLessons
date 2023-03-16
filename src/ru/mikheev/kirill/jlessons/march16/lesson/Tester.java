package ru.mikheev.kirill.jlessons.march16.lesson;

public class Tester {

    private String local = "Hello";

    public void test() {

        String ending = " world";

        Runnable decrementer = () -> {

            System.out.println(local + ending);
        };

        decrementer.run();
    }
}
