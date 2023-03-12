package ru.mikheev.kirill.jlessons.march12.lesson;

public class Queue {

    private Integer[] storage;

    private int startPivot = 0, endPivot = 0;
    private boolean isFull = false;

    public Queue(int size) {
        storage = new Integer[size];
    }

    public void putFirst(Integer elem) {
        if(isFull) throw new RuntimeException("QUEUE is full");

        storage[startPivot] = elem;
        startPivot = startPivot - 1 < 0 ? storage.length - 1 : startPivot - 1;
        if(startPivot == endPivot) isFull = true;
    }

    public Integer getLast() {
        if(storage[endPivot] == null) return null;

        var result = storage[endPivot];
        storage[endPivot] = null;
        endPivot = endPivot - 1 < 0 ? storage.length - 1 : endPivot - 1;
        isFull = false;
        return result;
    }

    public Integer checkLast() {
        return storage[endPivot];
    }

    public boolean isEmpty() {
        return !isFull && startPivot == endPivot;
    }
}
