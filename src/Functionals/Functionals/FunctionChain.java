package Functionals.Functionals;

import java.util.function.Function;

public class FunctionChain {
    public static void main(String[] args) {
        Function<String, String> removeColon = str -> str.replace("=", ":");
        Function<String, String> addBraces = str -> "{" + str + "}";

        System.out.println(removeColon.andThen(addBraces).apply("key:value"));
        System.out.println(addBraces.compose(removeColon).apply("key:value"));
    }
}
