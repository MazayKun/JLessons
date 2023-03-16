package ru.mikheev.kirill.jlessons.march16.lesson;

import java.util.Optional;
import java.util.function.Predicate;

public class Main {


    public static void main(String[] args) {

//        MyBeautifulInteger a = new MyBeautifulInteger(10);
//
//        Consumer<MyBeautifulInteger> incrementer = Main::increment;
//        Consumer<MyBeautifulInteger> decrementer = intToDecrease -> {
//            intToDecrease.decrement();
//            System.out.println(intToDecrease);
//        };
//
//
//        Consumer<MyBeautifulInteger> loafer = incrementer.andThen(decrementer);
//
//        loafer.accept(a);
//
//        Tester tester = new Tester();
//        tester.test();
//
//
//        Predicate<String> helloWorldPredicate = "Hello world"::equals;
//
//        Function<MyBeautifulInteger, MyBeautifulInteger> funcIncrementer = value -> {
//            value.increment();
//            return value;
//        };
//
//        Function<MyBeautifulInteger, Integer> integerConverter = MyBeautifulInteger::get;
//
//        Function<Integer, Integer> funcDecrementer = value -> {
//            value--;
//            return value;
//        };
//
//        var composedFuncs = integerConverter
//                .compose(funcIncrementer)
//                .andThen(funcDecrementer);

        Optional<String> optString = Optional.ofNullable(null);

        optString
                .filter((   (Predicate<String>) String::isBlank  ).negate())
                .map(value -> value + " world!")
                .or(() -> Optional.of("Custom"))
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("String is empty")
                );


        System.out.println(optString.toString());
        //System.out.println(composedFuncs.apply(a));
    }

    public static void increment(MyBeautifulInteger a) {
        a.increment();
        System.out.println(a);
    }

    private static class MyBeautifulInteger {
        private int a;

        public MyBeautifulInteger() {
            this.a = 10;
        }

        public MyBeautifulInteger(int a) {
            this.a = a;
        }

        public Integer get() {
            return a;
        }

        public void increment() {
            a++;
        }

        public void decrement() {
            a--;
        }

        @Override
        public String toString() {
            return "MyBeautifulInteger{" +
                    "a=" + a +
                    '}';
        }
    }


}
