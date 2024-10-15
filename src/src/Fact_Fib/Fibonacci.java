package Fact_Fib;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    int[] num;

    public Fibonacci(int n, Scanner sc) {
        num = new int[n];
        menu(sc, n);
    }

    private void menu(Scanner sc, int n) {
        System.out.println("Choose the method to calculate fibonacci numbers");
        System.out.println("1. By looping.");
        System.out.println("2. By recursion.");
        System.out.println("3. Return nth fibonacci number.");
        System.out.println("5. Exit");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                byLooping();
                break;
            case 2:
                byRecursion(0, 1, n, 0);
                break;
            case 3:
                System.out.println("Enter the nth number: ");
                int nth = sc.nextInt();
                byRecursion(0, 1, nth);
                break;
            case 5:
                return;
            default:
                System.out.println("Please enter a valid choice");
        }
    }

    private void byLooping(){
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

    private void byRecursion(int prev2, int prev1, int length, int count) {
        if (count < length) {
            // current Fib is printed only
            System.out.print(prev2 + " ");
            // Recursion, updating arguments, incrementation
            byRecursion(prev1, prev1 + prev2, length, count + 1);
        }
    }

    int count = 1;
    private void byRecursion(int prev2, int prev1, int nth) {
        if (count < nth) {
            count++;
            byRecursion(prev1, prev1+prev2, nth);
        }else{
            System.out.println("The "+ nth +"nth fibonacci number is " + prev2);
        }
    }
}
