package Streams.Terminal_Reducers;

import Streams.Intermediate_Terminal.Movie;

import java.util.List;

public class Reducer {
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
                .map(Movie::getLikes)
//                .reduce(0, Integer::sum) // the same as ((a, b) -> a+b)
                .reduce(Integer::sum)
//                .ifPresent(System.out::println);
        ;
//        System.out.println(result.get()); this will throw error if no value returned
        System.out.println(result.orElse(0)); // use result only for Integer result
    }
}
