package kth_largest_element;

public class Heap {
    protected int[] heap;
    protected int size;
    protected int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void heapify(int i) {
        // This method will be used by both MaxHeap and MinHeap
    }
}