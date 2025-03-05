package Collections.Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("a");
        queue.add("b");
        queue.add("c"); // offer() throws false if queue is full

        var front = queue.peek(); // element() throws exception when queue is empty
        var removed = queue.poll(); // remove() throws exceptions ````
        System.out.println(front);
        System.out.println(removed);
        System.out.println(queue);
    }
}
