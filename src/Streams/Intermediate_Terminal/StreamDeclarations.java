package Streams.Intermediate_Terminal;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamDeclarations {
    public static void main(String[] args) {
        // every class implementing Collection interface returns stream
                // Collection, ArrayList, List,

        // arrays use Arrays utility class
        int[] numbers = {1, 2, 3};
        Arrays.stream(numbers)
                .forEach(System.out::println);

        // Using 'of' static method
        Stream.of(1, 2, 3, 4); // finite elements

        // Infinite elements
        var stream = Stream.generate(Math::random); // method1
        stream.limit(3)
                .forEach(System.out::println);

        // method2
        var stream2 = Stream.iterate(0, i -> i + 1);
        stream2.limit(11)
                .forEach(System.out::println);
    }
}
