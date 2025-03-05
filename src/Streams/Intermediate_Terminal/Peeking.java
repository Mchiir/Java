package Streams.Intermediate_Terminal;

import java.util.List;

public class Peeking {
    public static void main(String[] args) {
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 2),
                new Movie("d", 40),
                new Movie("e", 1),
                new Movie("f", 100)
        );
        // for troubleshooting use peek()
        movies.stream()
                .filter(m -> m.getLikes() > 10)
                .peek(m -> System.out.println("Filtered: "+ m.getTitle()))
                .map(m -> m.getTitle())
                .peek(m -> System.out.println("Peeked: "+ m))
                .forEach(m -> System.out.println(m));
    }
}
