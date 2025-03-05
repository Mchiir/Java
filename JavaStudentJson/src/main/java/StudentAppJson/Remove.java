package StudentAppJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Remove {
    private String filePath;
    private ObjectMapper objectMapper;

    public Remove(String filePath) {
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
        try {
			showMenu();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    private void showMenu() throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Remove Student Menu:");
            System.out.println("1. Remove first student");
            System.out.println("2. Remove last student");
            System.out.println("3. Remove by line number");
            System.out.print("Select an option (1-3): ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    removeFirstStudent();
                    break;
                case 2:
                    removeLastStudent();
                    break;
                case 3:
                    System.out.print("Enter line number to remove: ");
                    int lineNumber = Integer.parseInt(scanner.nextLine());
                    removeByLineNumber(lineNumber);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    showMenu();
                    break;
            }
        }
    }

    private void removeFirstStudent() {
        List<Student> students = readStudentsFromFile();
        if (!students.isEmpty()) {
            Student studentToRemove = students.get(0);
            displayStudent(studentToRemove);
            if (getConfirmation()) {
                students.remove(0);
                writeStudentsToFile(students);
                System.out.println("First student removed successfully.");
            } else {
                System.out.println("Removal canceled.");
            }
        } else {
            System.out.println("No students to remove.");
        }
    }

    private void removeLastStudent() {
        List<Student> students = readStudentsFromFile();
        if (!students.isEmpty()) {
            Student studentToRemove = students.get(students.size() - 1);
            displayStudent(studentToRemove);
            if (getConfirmation()) {
                students.remove(students.size() - 1);
                writeStudentsToFile(students);
                System.out.println("Last student removed successfully.");
            } else {
                System.out.println("Removal canceled.");
            }
        } else {
            System.out.println("No students to remove.");
        }
    }

    private void removeByLineNumber(int lineNumber) {
        List<Student> students = readStudentsFromFile();
        if (lineNumber > 0 && lineNumber <= students.size()) {
            Student studentToRemove = students.get(lineNumber - 1);
            displayStudent(studentToRemove);
            if (getConfirmation()) {
                students.remove(lineNumber - 1);
                writeStudentsToFile(students);
                System.out.println("Student at line " + lineNumber + " removed successfully.");
            } else {
                System.out.println("Removal canceled.");
            }
        } else {
            System.out.println("Invalid line number.");
        }
    }

    private void displayStudent(Student student) {
        System.out.println("\nStudent details:");
        System.out.println(student); // Pretty print JSON
    }

    private boolean getConfirmation() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Are you sure you want to delete this student? (1 for Yes, 0 for No): ");
            int confirmation = Integer.parseInt(scanner.nextLine());
            return confirmation == 1;
        } catch (NumberFormatException e) {
            return false; // Default to no on error
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
        return new ArrayList<>();
    }

    private void writeStudentsToFile(List<Student> students) {
        try {
            objectMapper.writeValue(new File(filePath), students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}