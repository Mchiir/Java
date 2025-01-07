package kth_largest_element;

public class MaxHeap extends Heap {
    private static void heapify(int[] array) {
        for (int i = (array.length / 2) - 1; i >= 0; i--)
            heapify(array, i, array.length);
    }

    private static void heapify(int[] array, int index, int size) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && array[left] > array[largest])
            largest = left;

        if (right < size && array[right] > array[largest])
            largest = right;

        if (largest != index) {
            swap(array, index, largest);
            heapify(array, largest, size);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int getKthLargest(int[] array, int k) {
        if (k > array.length || k < 1)
            throw new IllegalArgumentException();

        var heap = new Heap();
        for (var number : array)
            heap.insert(number);

        for (var i = 0; i < k - 1; i++)
            heap.remove();

        return heap.max();
    }
}