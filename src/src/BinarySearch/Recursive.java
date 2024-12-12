package BinarySearch;

import java.util.List;

public class Recursive {
    private static int BinarySearchRec(int[] arr,int target, int left, int right){
        int mid = (left + right)/2;
        if(right < left){
            return -1;
        }
        if(arr[mid] == target){ return mid; }
        if(arr[right] == target){ return right; }
        if(arr[left] == target){ return left; }
        if(target < arr[mid]){
            return BinarySearchRec(arr,target, left, mid-1);
        }
        if(target > arr[mid]){ }; // implemented in last return

        return BinarySearchRec(arr,target, mid+1, right);
    }

    static int s(int[] arr, int key){
        return BinarySearchRec(arr,key, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(s(arr, 3));
    }
}
