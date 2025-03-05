package Functionals.Functionals;

import java.util.function.Predicate;

public class PredicateChain {
    public static void main(String[] args) {
        Predicate<String> hasLeftBrace = s -> s.startsWith("{");
        Predicate<String> hasRightBrace = s -> s.endsWith("}");

        Predicate<String>  // consider use of AND
                hasLeftAndRightBrace = hasLeftBrace.and(hasRightBrace);// Use also ||, !
        var result = hasLeftBrace.and(hasRightBrace).test("{Hello world}");


        System.out.println(result);
        System.out.println(hasLeftAndRightBrace.negate().test("{Hello world}"));
        System.out.println(hasLeftBrace.or(hasRightBrace).test("{Hello world"));
    }
}
