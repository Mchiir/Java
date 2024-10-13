package StudentQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Student> queue = new LinkedList<>();
        queue.add(new Student(1, "Mugisha", 'B'));
        queue.add(new Student(2, "Bob", 'B'));
        queue.add(new Student(3, "Jack", 'M'));

        while (!queue.isEmpty()) {
            Student student = queue.poll();
            System.out.println(student);
        }
    }
}
