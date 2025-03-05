package Streams.Terminal_Reducers;

import Streams.Intermediate_Terminal.Movie;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsDemo {
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
                .filter(m -> m.getLikes() > 10)
//                .collect(Collectors.toList()); // use to toSet() also
//                .collect(Collectors.toMap(Movie::getTitle, m->m.getLikes())); the same as below
//                .collect(Collectors.toMap(m->m.getTitle(), m->m)); the same as below
                .collect(Collectors.toMap(m->m.getTitle(), Function.identity()));

        System.out.println(result);

        var result2 = movies.stream()
                .filter(m -> m.getLikes() > 10)
//                .collect(Collectors.summingInt(Movie::getLikes)); // use also summingDouble
                .collect(Collectors.summarizingInt(m->m.getLikes()));

        System.out.println(result2);
        var result3 = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .map(Movie::getTitle)
                .collect(Collectors.joining(", "));
        System.out.println(result3);
    }
}
