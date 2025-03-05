package Functionals.Functionals;

import java.util.List;
import java.util.function.Consumer;

public class FunctionChaining {
    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c");
        Consumer<String> print = message -> System.out.println(message);
        Consumer<String> printUpperCase = message -> System.out.println(message.toUpperCase());
        Consumer<String> printSub = FunctionChaining::accept;

        list.forEach(print.andThen(printUpperCase).andThen(printSub));
    }

    private static void accept(String message) {
        System.out.println(message.substring(0));
    }
}