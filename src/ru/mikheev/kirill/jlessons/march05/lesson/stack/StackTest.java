package ru.mikheev.kirill.jlessons.march05.lesson.stack;

public class StackTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push('a');
        stack.push('b');
        stack.push('c');
        for (var character : stack){
            System.out.println(character);
        }
    }

}
