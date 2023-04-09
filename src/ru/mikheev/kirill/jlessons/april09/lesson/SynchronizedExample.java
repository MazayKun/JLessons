package ru.mikheev.kirill.jlessons.april09.lesson;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedExample {

    private static Object lock = new Object();

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 10; i++ )  {
            threads.add(new Thread(SynchronizedExample::showMeWhatUGot));
        }
        for(var thread : threads) {
            thread.start();
        }
    }

    public static synchronized void showMeWhatUGot() {
        synchronized (lock) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName());
    }
}
