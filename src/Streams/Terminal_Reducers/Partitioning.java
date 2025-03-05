package Streams.Terminal_Reducers;

import java.util.List;
import java.util.stream.Collectors;

public class Partitioning {
    public static void main(String[] args) {
        List<Movie> movies = List.of(
                new Movie("a", 10, Genre.THRILLER),
                new Movie("b", 15, Genre.ACTION),
                new Movie("c", 20, Genre.ACTION)
        );

        var result = movies.stream()
                .collect(Collectors.partitioningBy(
                        movie -> movie.getLikes() > 10,
                        Collectors.mapping(Movie::getTitle,
                                Collectors.joining(",  "))
                ));
        System.out.println(result);// we have one part for true and other for false
    }
}
