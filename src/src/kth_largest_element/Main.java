package kth_largest_element;

import java.util.Arrays;

public class Main {
    public static int findKthLargest(int[] nums, int k) {
        MaxHeap maxHeap = new MaxHeap(nums.length);

        // Build the max-heap with all the elements
        for (int num : nums) {
            maxHeap.insert(num);
        }

        // Extract the maximum element k times to get the kth largest element
        int kthLargest = -1;
        for (int i = 0; i < k; i++) {
            kthLargest = maxHeap.extractMax();
        }

        return kthLargest;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 6;

        if (k < 1 || k > nums.length) {
            throw new IllegalArgumentException("k must be between 1 and " + nums.length);
        }

        System.out.println("The " + k + "th largest number is: " + findKthLargest(nums, k));
    }
}