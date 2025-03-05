package Streams.Intermediate_Terminal;

import java.util.List;

public class StreamSlicing {
    public static void main(String[] args) {
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 2),
                new Movie("d", 40),
                new Movie("e", 1),
                new Movie("f", 100)
        );

//        movies.stream()
//                .skip(2) // skip first 2 || you can also limit() to 2 onlu
//                .forEach(System.out::println);
//        movies.stream()
//                .takeWhile(movie -> movie.getLikes() > 10) // stops for initial false
//                .forEach(System.out::println);
        movies.stream()
                .dropWhile(movie -> movie.getLikes() > 10)
                .forEach(System.out::println);
        // use dropWhile(),
    }
}