package Functionals.Functionals;

import java.util.function.Supplier;

public class Suplier {
    public static void main(String[] args) {
        Supplier<Double> getRandom = () -> Math.random();
        System.out.println(getRandom.get());
    }
}
