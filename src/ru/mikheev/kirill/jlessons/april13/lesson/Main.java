package ru.mikheev.kirill.jlessons.april13.lesson;

import ru.mikheev.kirill.jlessons.april09.lesson.RandomIntGenerator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] ints = new Integer[30000];
        try (RandomIntGenerator intGenerator = new RandomIntGenerator(0, 200_000)) {
            for (int i = 0; i < ints.length; i++) {
                ints[i] = intGenerator.next();
            }
        }

        ParallelMinFinder finder = new ParallelMinFinder();
        var result = finder.findMinimum(ints);

        var test = Arrays.stream(ints)
                .min(Integer::compareTo)
                .orElseThrow();
        System.out.println(test + " " + result);
        System.out.println(test.compareTo(result) == 0);
    }
}
