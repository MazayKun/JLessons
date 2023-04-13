package ru.mikheev.kirill.jlessons.april09.lesson;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomIntGenerator implements Iterator<Integer>, AutoCloseable {

    private boolean isClosed = false;
    private final Random random = new Random();
    private final int start, end;

    public RandomIntGenerator(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void close() {
        isClosed = true;
    }

    @Override
    public boolean hasNext() {
        return !isClosed;
    }

    @Override
    public Integer next() {
        if(isClosed) throw new NoSuchElementException("Generator was closed");
        return random.nextInt(end - start) + start;
    }
}
