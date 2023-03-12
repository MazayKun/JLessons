package ru.mikheev.kirill.jlessons.march12.lesson;

public class HashMap {

    private final double loadFactor = 0.75;
    private final int threshold = 6;

    private int bucketsOccupied = 0;

    private Entry[] buckets;

    public HashMap() {
        this(8);
    }

    public HashMap(int initialCapacity) {
        buckets = new Entry[initialCapacity];
    }

    public void put(String key, Integer value) {
        if(key == null) throw new NullPointerException("Null is not allowed in my beautiful map");
        if(value == null) throw new NullPointerException("Null is not allowed in my beautiful map");

        int hash = hash(key);
        int position = hash % buckets.length;
        if(buckets[position] == null ) {
            bucketsOccupied++;
            if((double)bucketsOccupied / buckets.length >= loadFactor) {
                rebalance(key, value);
            }else{
                buckets[position] = new Entry(key, value);
            }
            return;
        }

        Entry current = buckets[position];
        int counter = 1;
        while(current.next != null) {
            current = current.next;
            counter++;
        }

        if(counter + 1 >= threshold) {
            System.out.println("COUNTER - " + (counter + 1));
            rebalance(key, value);
            return;
        }

        current.next = new Entry(key, value);
    }

    public Integer get(String key) {
        int hash = hash(key);
        int position = hash % buckets.length;
        Entry current = buckets[position];
        while(current != null) {
            if(current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    private void rebalance(String key, Integer value) {
        System.out.println("REBALANCING (" + key + " : " + value + ")");
        Entry[] newBuckets = new Entry[buckets.length * 2];

        for(var entry : buckets) {
            if(entry != null) {
                putEntryWithRebalanced(entry, newBuckets);
                Entry next = entry.next;
                entry.next = null;
                while(next != null) {
                    putEntryWithRebalanced(next, newBuckets);
                    Entry tmp = next.next;
                    next.next = null;
                    next = tmp;
                }
            }
        }

        this.buckets = newBuckets;
        this.bucketsOccupied = 0;
        for(var entry : buckets) {
            if(entry != null) bucketsOccupied++;
        }
    }

    private void putEntryWithRebalanced(Entry entry, Entry[] newBuckets) {
        int hash = hash(entry.key);
        int position = hash % newBuckets.length;
        if(newBuckets[position] == null ) {
            newBuckets[position] = entry;
            return;
        }

        Entry current = newBuckets[position];
        while(current.next != null)
            current = current.next;

        current.next = entry;
    }




    private int hash(String key) {
        return key.hashCode();
    }



    private class Entry {
        String key;
        Integer value;
        Entry next;

        Entry(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
}
