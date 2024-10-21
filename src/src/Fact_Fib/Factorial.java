package Fact_Fib;

public class Factorial {
    int n;

    public Factorial(int n) {
        this.n = n;
        System.out.println("The factorial of "+ n +" is "+ fact((double)n));
    }

    public double fact(double n) {
        if (n > 20){
            System.out.println("The number is too large!, pass a number less than or equal to 20.");
            return 0;
        }else if (n < 0){
            System.out.println("There's no factorial for negative numbers!, please provide positive numbers.");
            return 0;
        }else if (n == 0)
            return 1;
        else
            return n * fact(n-1);
    }
}