package ru.mikheev.kirill.jlessons.april09.lesson;

public class RndGenTest {
    public static void main(String[] args) {
        RandomIntGenerator rnd = new RandomIntGenerator(0, 10);
        try (rnd){
            for(int i = 0; i < 1000; i++) {
                System.out.println(rnd.next());
            }
            System.out.println(rnd.hasNext());
        }
        System.out.println(rnd.hasNext());
    }
}
