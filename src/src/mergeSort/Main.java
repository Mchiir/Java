package mergeSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2,3,1,4,5,2,6,7,2};
        new Main().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] array){
        // divide this array into half
        // Sort each half
        // merge the result
        if(array.length < 2)
            return;

        var middle = array.length/2;
        int left[] = new int[middle];
        for(int i=0; i<middle; i++)
            left[i] = array[i];

        int right[] = new int[array.length-middle];
        for(int i=middle; i<array.length; i++)
            right[i-middle] = array[i];

        // Sort each half
        sort(left);
        sort(right);

        // merge the result
        merge(left, right, array);
    }

    public static void merge(int[] left, int[] right, int[] result){
        int i=0, j=0, k=0;

        while(i < left.length && j < right.length){
            if(left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        while(i < left.length)
            result[k++] = left[i++];
        while(j < right.length)
            result[k++] = right[j++];
    }
}