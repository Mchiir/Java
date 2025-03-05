package Streams.Terminal_Reducers;

import Streams.Intermediate_Terminal.Movie;

import java.util.Comparator;
import java.util.List;

public class SimpleReducers {
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

        var result = movies.stream()
//                .count(); returnes LONG No. of elements
//                .anyMatch(m -> m.getLikes() > 20); returns a boolean
//                .allMatch(m->m.getLikes() > 20); returns a boolean
//                .noneMatch(m->m.getLikes() > 20); returns a boolean
//                .findFirst().get(); returns 1st movie as OPTIONAL
//                .findAny().get();
                .max(Comparator.comparing(Movie::getLikes)).get();
//                .min(Comparator.comparing(Movie::getLikes)).get();

        System.out.println(result);
    }
}
