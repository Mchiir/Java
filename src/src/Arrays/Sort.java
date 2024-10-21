package Arrays;
import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    private final int[] numbers;
    private int iterations = 0;
    private int operations = 0;
    private final int length;

    public Sort(int[] numbers) {
        this.numbers = numbers;
        this.length = numbers.length;
        menu();
    }

    private void menu() {
        var sc = new Scanner(System.in);
        System.out.println("Welcome to the sorting program");
        System.out.println("1. Bubble sort.");
        System.out.println("2. Selection sort.");
        System.out.println("3. Insertion sort.");
        System.out.println("9. Exit the program.");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Bubble();
                break;
            case 2:
                Selection();
                break;
            case 3:
                Insertion();
                break;
            case 9:
                System.out.println("Goodbye!");
                return;
            default:
                System.out.println("Invalid choice");
            sc.close();
        }
    }

    private void Bubble() {
        for(int n=0; n<length-1; n++){
            boolean swappped  = false;
            iterations++;
            for(int j=0; j< length-1; j++){
                if(numbers[j]>numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                    swappped  = true;
                    operations++;
                }
                operations++;
            }
            if(!swappped) break;
        }
    }

    private void Selection() {
        for (int n=0; n<length-1; n++) {
            iterations++;
            int low_index = n;
            for(int j= n+1; j< length; j++){
                operations++;
                if(numbers[j]< numbers[low_index]) {
                    low_index = j;
                }
            }

            if (low_index != n) {
                int temp = numbers[low_index];
                numbers[low_index] = numbers[n];
                numbers[n] = temp;
            }
        }
    }

    private void Insertion() {
        for (int n=1; n<length; n++) {
            iterations++;
            int current_val = numbers[n];
            int j = n-1;

            while(j >= 0 && numbers[j] > current_val){
                numbers[j + 1] = numbers[j];
                j--;
                operations++;
            }
            numbers[j+1] = current_val;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers);
    }

    public int getIterations() {
        return iterations;
    }

    public int getOperations() {
        return operations;
    }
}
