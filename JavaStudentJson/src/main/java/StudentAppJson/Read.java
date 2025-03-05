package StudentAppJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Read {
    private String filePath;
    private ObjectMapper objectMapper;

    public Read(String filePath) {
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
        displayMenu();
    }

    public void displayMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose an option:");
            System.out.println("1. Read First Student");
            System.out.println("2. Read Last Student");
            System.out.println("3. Read Student by Line Number");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("First student:");
                    System.out.println(readFirstStudent());
                    break;

                case 2:
                    System.out.println("Last student:");
                    System.out.println(readLastStudent());
                    break;

                case 3:
                    System.out.println("Enter line number:");
                    int lineNumber = Integer.parseInt(scanner.nextLine());
                    System.out.println("Student at line " + lineNumber + ":");
                    System.out.println(readStudentByLine(lineNumber));
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFirstStudent() throws IOException {
        List<Student> students = readStudentsFromFile();
        if (!students.isEmpty()) {
            return students.get(0).toString();
        } else {
            return "File is empty.";
        }
    }

    public String readLastStudent() throws IOException {
        List<Student> students = readStudentsFromFile();
        if (!students.isEmpty()) {
            return students.get(students.size() - 1).toString();
        } else {
            return "File is empty.";
        }
    }

    public String readStudentByLine(int lineNumber) throws IOException {
        List<Student> students = readStudentsFromFile();
        if (lineNumber > 0 && lineNumber <= students.size()) {
            return students.get(lineNumber - 1).toString();
        } else {
            return "No student found at line " + lineNumber;
        }
    }

    private List<Student> readStudentsFromFile() {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return List.of(objectMapper.readValue(file, Student[].class));
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
        return List.of();
    }
}