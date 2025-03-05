package Streams.Terminal_Reducers;

import java.util.List;
import java.util.stream.Collectors;

public class GroupingsDemo {
    public static void main(String[] args) {
        List<Movie> movies = List.of(
                new Movie("a", 10, Genre.THRILLER),
                new Movie("b", 15, Genre.ACTION),
                new Movie("c", 20, Genre.ACTION)
        );

        var result = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));
        System.out.println(result);

        var result2 = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.toSet()));
        System.out.println(result2);

        var result3 = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.mapping(Movie::getTitle, Collectors.joining(", "))));
        System.out.println(result3);
    }
}
