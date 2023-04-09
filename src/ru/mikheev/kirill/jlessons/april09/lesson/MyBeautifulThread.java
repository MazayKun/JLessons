package ru.mikheev.kirill.jlessons.april09.lesson;

public class MyBeautifulThread extends Thread {

    private boolean isRunning = false;
    private boolean isInterrupted = false;

    @Override
    public synchronized void start() {
        isRunning = true;
        super.start();
    }

    @Override
    public void run() {
        ol:while(true) {
            System.out.println(System.currentTimeMillis() / 1000 % 60);

            var startTime = System.currentTimeMillis();
            while(System.currentTimeMillis() - startTime < 1000L) {
                if(isInterrupted) break ol;
                Thread.yield();
            }
        }
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void customInterrupt() {
        isInterrupted = true;
    }
}
