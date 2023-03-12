package ru.mikheev.kirill.jlessons.march05.lesson.singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingletonTest {

    public static void main(String[] args) {
        Singleton myBeautifulSingleton = Singleton.getSingletonInstance();
        List<Integer> ints = new ArrayList<>(List.of(1,2,3,4));
        Map<String, Integer> nameToAge = new HashMap<>();
        nameToAge.put("Kirill", 23);
        System.out.println(nameToAge.get("Kirill"));
        for(var pair : nameToAge.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }
}
