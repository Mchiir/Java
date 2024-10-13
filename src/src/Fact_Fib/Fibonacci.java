package Fact_Fib;

import java.util.Arrays;

public class Fibonacci {
    int[] num;

    public Fibonacci(int n) {
        num = new int[n];
        Fib();
    }

    public void Fib(){
        for (int i = 0; i < num.length; i++){
            if (i == 0){
                num[i] = 0;
            }else if (i == 1){
                num[i] = 1;
            }else
                num[i] = num[i-1] + num[i-2];
        }

        System.out.println(Arrays.toString(num));
    }
}
