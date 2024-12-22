package SelectionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Best and worst case of O(n^2) quadratic complexity
// due to essential comparisons(O(n)) and passes(O(n))

public class LoopingSort {
    public static void main(String[] args) {
        Integer[] arr1 = {7,7,7,8,3};
        for(int i=0; i< arr1.length-1; i++) {
            int min = i;
            for (int j = i + 1; j < arr1.length; j++)
                if (arr1[min] > arr1[j])
                    min = j;

            int temp = arr1[i];
            arr1[i] = arr1[min];
            arr1[min] = temp;
        }

        System.out.println(Arrays.toString(arr1));
    }
}