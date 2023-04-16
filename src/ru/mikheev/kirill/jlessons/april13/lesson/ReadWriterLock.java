package ru.mikheev.kirill.jlessons.april13.lesson;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReadWriterLock {

    private final AtomicInteger readCounter, writeCounter;

    private final ReentrantLock lock;
    private final Condition readCondition, writeCondition;

    public ReadWriterLock() {
        readCounter = new AtomicInteger(0);
        writeCounter = new AtomicInteger(0);
        this.lock = new ReentrantLock();
        readCondition = lock.newCondition();
        writeCondition = lock.newCondition();
    }

    public void requestRead() throws InterruptedException {
        while(writeCounter.get() > 0) readCondition.await();
        readCounter.incrementAndGet();
    }

    public void releaseRead() {
        readCounter.decrementAndGet();
        if(readCounter.get() <= 0) writeCondition.signal();
    }

    public void requestWrite() throws InterruptedException {
        lock.lock();
        while(writeCounter.get() > 0 || readCounter.get() > 0) writeCondition.await();
        writeCounter.incrementAndGet();
        lock.unlock();
    }

    public void releaseWrite() {
        writeCounter.decrementAndGet();
        writeCondition.signal();
        readCondition.signal();
    }
}
