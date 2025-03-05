package Streams.Intermediate_Terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamMapping {
    public static void main(String[] args) {
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );

        movies.stream()
                .map(movie -> movie.getLikes())
                .forEach(System.out::println);
        List<Integer> numbers = new ArrayList<>();

        var result = Stream.of(List.of(1,2,3), List.of(4, 5, 6));
        result.flatMap(List::stream)
                .forEach(numbers::add);
        System.out.println(numbers);
//        result.forEach(System.out::println); // not functional
    }
}
