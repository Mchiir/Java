package Fact_Fib;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        new Fibonacci(10, sc);
        sleep(100);
//        new Factorial(21);
        sc.close();
    }
}
