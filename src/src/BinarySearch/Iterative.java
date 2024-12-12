package BinarySearch;

public class Iterative {
    private static int BinarySearchIter(int[] arr, int target, int start, int end) {
        while (end >= start) {
            int mid = (start + end) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[start] == target)
                return start;// increase performance
            if (arr[end] == target)
                return end; // increase performance

            if (target < arr[mid])
                end = mid - 1;

            if (target > arr[mid])
                start = mid + 1;
        }
        return -1;
    }

    static int s(int[] arr, int target) {
      return BinarySearchIter(arr, target, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 7, 8, 8};
        System.out.println(s(arr, 3));
    }
}
