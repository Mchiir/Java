package BinarySearch;

public class Iterative {
    private static int BinarySearchIter(int[] arr, int target, int start, int end) {
        return 0;
    }

    static int s(int[] arr, int target) {
      return BinarySearchIter(arr, target, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 8};
        System.out.println(s(arr, 2));
    }
}
