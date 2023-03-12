package ru.mikheev.kirill.jlessons.march05.lesson.singleton;

public class Singleton {

    private String name;
    private static Singleton thisSingleton = null;

    private Singleton() {
        name = "MySingleton";
    }

    public static Singleton getSingletonInstance()  {
        if(thisSingleton == null) {
            thisSingleton = new Singleton();
        }
        return thisSingleton;
    }
}
