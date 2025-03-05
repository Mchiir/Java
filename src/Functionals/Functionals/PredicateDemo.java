package Functionals.Functionals;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> isLongerThanFive = s -> s.length() > 5;

        System.out.println(isLongerThanFive.test("Hello"));
    }
}
