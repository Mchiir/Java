package Streams.Intermediate_Terminal;

import java.util.Comparator;
import java.util.List;

public class SortingRemovingDuplicates {
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

        movies.stream()
                .sorted(Comparator.comparing(Movie::getTitle))
                .distinct()
                .forEach(System.out::println);
        }
}
