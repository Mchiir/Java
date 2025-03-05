package Functionals.Functionals;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class BinaryUnaryOperatorsDemo {
    public static void main(String[] args) {
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        UnaryOperator<Integer> square = a -> a * a;
        System.out.println(sum.andThen(square).apply(2, 3));
    }
}
