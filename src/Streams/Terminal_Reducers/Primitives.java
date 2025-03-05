package Streams.Terminal_Reducers;

import java.util.stream.IntStream;

public class Primitives {
    public static void main(String[] args) {
        IntStream.of(1, 2, 3);// there's also for Double and Long
        IntStream.range(0, 10).forEach(System.out::println);
        IntStream.rangeClosed(1, 10).forEach(System.out::println);
    }
}
