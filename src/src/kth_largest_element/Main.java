package kth_largest_element;

public class Main {
    public static void main(String[] args) {
        int[] numbers = { 5,3,4,6,7,2,1 };
        System.out.println(MaxHeap.getKthLargest(numbers, 7));
    }
}