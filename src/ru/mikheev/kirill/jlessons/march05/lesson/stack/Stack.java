package ru.mikheev.kirill.jlessons.march05.lesson.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack implements Iterable<Character> {

    private StackNode root;

    public void push(Character newValue) {
        if(root == null) {
            root = new StackNode();
            root.value = newValue;
            return;
        }
        var tmp = root;
        this.root = new StackNode();
        root.value = newValue;
        root.next = tmp;
    }

    public Character showUpperElement() {
        if(root != null)
            return root.value;
        return null;
    }

    public Character pop() {
        if(root != null) {
            var result = root.value;
            this.root = this.root.next;
            return result;
        }
        return null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Character> iterator() {

        return new Iterator<>() {

            StackNode current = root;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Character next() {
                if(current == null) throw new NoSuchElementException("There is no next element in this Stack");
                var result = current.value;
                current = current.next;

                return result;
            }
        };
    }


    private class StackNode {
        Character value;
        StackNode next;
    }
}
