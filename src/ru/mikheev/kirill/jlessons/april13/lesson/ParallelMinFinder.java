package ru.mikheev.kirill.jlessons.april13.lesson;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Supplier;

public class ParallelMinFinder {

    private static final int STEP = 500;

    private Integer[] localMins;
    private volatile int fillFactor;
    private final MyQueue taskQueue = new MyQueue();

    public Integer findMinimum(Integer[] ints) {
        if(ints.length <= 500) {
            return findMin(ints, 0, ints.length);
        }
        Worker[] workers = new Worker[3];
        for(int i = 0; i < 3; i++) {
            Worker worker = new Worker();
            workers[i] = worker;
            worker.start();
        }
        localMins = new Integer[ints.length / STEP + 1];
        fillFactor = 0;
        for(int i = 0; i < ints.length; i += STEP) {
            final int start = i;
            taskQueue.add(() -> findMin(ints, start, Math.min(start + STEP, ints.length)));
        }

        taskQueue.finish();
        for(var worker : workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Arrays.toString(localMins));
        return findMin(localMins, 0, fillFactor);
    }

    public Integer findMin(Integer[] ints, int start, int end) {
        Integer result = ints[start];
        for(int i = start + 1; i < end; i++) {
            if(ints[i] < result) {
                result = ints[i];
            }
        }
        return result;
    }

    private synchronized void addLocalResult(Integer localMin) {
        localMins[fillFactor] = localMin;
        fillFactor++;
    }

    private static class MyQueue {

        private boolean isFinished = false;
        private final Deque<Supplier<Integer>> innerQueue = new LinkedList<>();

        public void finish() {
            isFinished = true;
        }

        public Supplier<Integer> next() {
            Supplier<Integer> task;

            while(innerQueue.isEmpty()) {
                if(isFinished) {
                    return null;
                }
                Thread.yield();
            }
            synchronized (innerQueue) {
                task = innerQueue.pollLast();
            }
            return task;
        }

        public void add(Supplier<Integer> task) {
            synchronized (innerQueue) {
                innerQueue.addFirst(task);
            }
        }

        public boolean mayHasNext() {
            return !(isFinished && innerQueue.isEmpty());
        }
    }

    private class Worker extends Thread {

        @Override
        public void run() {
            while(taskQueue.mayHasNext()) {
                var task = taskQueue.next();
                if(task == null) continue;
                var localMin = task.get();
                addLocalResult(localMin);
            }
        }
    }
}
