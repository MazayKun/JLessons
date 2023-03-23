package ru.mikheev.kirill.jlessons.march19.lesson;

public class Main {
    public static void main(String[] args) {


//        System.out.println(IntStream.rangeClosed(8, 12)
//                .filter(a -> a > 3)
//                        .average().getAsDouble());
//
//        Stream.of(1,2,3,4,5,6)
//                .filter(a -> a > 3)
//                .forEach(System.out::println);

//        List<Pair> newList = new ArrayList<>();
//        for(int i = 0; i < 10; i++) {
//            newList.add(new Pair("HELLO", "WORLD"));
//        }

//        System.out.println(newList.parallelStream()
//                .reduce(0, (a,b) -> {
//                    System.out.println(a + " " + b);
//                    if(b % 3 == 0) {
//                        return a - b;
//                    }
//                    return  a + b;
//                }));


//        newList.stream()
//                .distinct()
//                .flatMap(pair -> {
//                    var arr = pair.getLeft().toCharArray();
//                    return IntStream.range(0, arr.length).mapToObj(i -> arr[i]);
//                })
//                .forEach(System.out::println);


//        for(var mapEntity : map.entrySet()) {
//            System.out.println(mapEntity.getKey() + " = " + mapEntity.getValue());
//        }


    }

    static class Pair {

        static long id_counter = 0;

        long id;
        String left;
        String right;

        public Pair(String left, String right) {
            this.id = id_counter;
            id_counter++;
            if(getId() == 5) id = 4;
            this.left = left;
            this.right = right;
        }

        public String getLeft() {
            return left;
        }

        public String getRight() {
            return right;
        }

        public long getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "id=" + id +
                    ", left='" + left + '\'' +
                    ", right='" + right + '\'' +
                    '}';
        }
    }
}
