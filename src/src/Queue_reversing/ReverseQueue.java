package Queue_reversing;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    private Queue<Integer> queue;

    public ReverseQueue(Queue<Integer> queue) {
        setQueue(queue);
        reverseQueue(queue);
    }

    private void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }

        int front = queue.remove();
        reverseQueue(queue);
        queue.add(front);
    }

    public void printQueue(Queue<Integer> queue) {
        for (Integer element : queue) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private void setQueue(Queue<Integer> queue) {
        if (queue.isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        this.queue = queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println("Original Queue:");
        new ReverseQueue(queue).printQueue(queue);  // Print original queue

        System.out.println("Reversed Queue:");
        new ReverseQueue(queue).printQueue(queue);  // Print reversed queue
    }
}