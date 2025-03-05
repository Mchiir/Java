package Streams.Intermediate_Terminal;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ImperativeProgramming {
    public static void main(String[] args) {
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );

        // imperial programming paradigm (Hows)
        int count = 0;
        for (Movie movie : movies) {
            if(movie.getLikes() > 10)
                count++;
        }
//        System.out.println(count);

        //Declarative or functional prog paradigm (Whats)
        Predicate<Movie> isPopular = movie -> movie.getLikes() > 10; // pass to filter()
        var counted = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .count();
//                .forEach(System.out::println);
        System.out.println(counted);

        movies.stream()
                .map(Movie::getTitle) // intermediate stream method have stream returns
                .forEach(System.out::println); // terminal method have voids

        var lists = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6));
        lists
                .flatMap(list -> list.stream()) // Stream<List<x>> -> Stream<x>
                .forEach(System.out::println);
    }
}
