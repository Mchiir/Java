package kth_largest_element;

public class MaxHeap extends Heap {

    public MaxHeap(int capacity) {
        super(capacity);
    }

    public void insert(int val) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full");
        }

        heap[size] = val;
        size++;
        int i = size - 1;
        // Bubble up the new element to restore heap property
        while (i != 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return root;
    }

    @Override
    public void heapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }
}