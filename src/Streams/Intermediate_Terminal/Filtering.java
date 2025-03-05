package Streams.Intermediate_Terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filtering {
    public static void main(String[] args) {
    List<Movie> movies = List.of(
            new Movie("a", 10),
            new Movie("b", 15),
            new Movie("c", 20)
    );

    List<Movie> popularMovies = new ArrayList<>();
    Predicate<Movie> isPopular = movie -> movie.getLikes() > 10;
    movies.stream()
            .filter(isPopular)
            .forEach(popularMovies::add);
        System.out.println(popularMovies);
    }
}
