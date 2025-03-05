package StudentManagement;

import java.util.Arrays;

public class Students {
    public static void main(String[] args) {
        var student1 = new Student("Kamaliza", 20, 88.9);
        var student2 = new Student("Kamaliza", 20, 88.9);

        student1.display(new String[]{student2.getName()});
    }
}