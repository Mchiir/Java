package StudentAppJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Insert {
    private String filePath;
    private ObjectMapper objectMapper;

    public Insert(String filePath) {
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
        promptUserForStudentData();
    }

    private void promptUserForStudentData() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int line = getNextLineNumber();

            System.out.println("Enter student name:");
            String name = reader.readLine();

            System.out.println("Enter student age:");
            int age = Integer.parseInt(reader.readLine());

            Student student = new Student();
            student.setLine(line);
            student.setName(name);
            student.setAge(age);

            writeStudentToFile(student);
            System.out.println("Student data inserted successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getNextLineNumber() {
        List<Student> students = readStudentsFromFile();
        return students.size() + 1; // Next line number
    }

    private void writeStudentToFile(Student student) {
        try {
            List<Student> students = readStudentsFromFile();
            students.add(student);
            objectMapper.writeValue(new File(filePath), students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Student> readStudentsFromFile() {
        List<Student> students = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (file.exists()) {
                Student[] studentArray = objectMapper.readValue(file, Student[].class);
                for (Student student : studentArray) {
                    students.add(student);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
        return students;
    }
}