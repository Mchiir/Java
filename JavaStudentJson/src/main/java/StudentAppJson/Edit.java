package StudentAppJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Edit {
    private String filePath;
    private ObjectMapper objectMapper;

    public Edit(String filePath) {
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
        try {
			showMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void showMenu() throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Edit Student Menu:");
            System.out.println("1. Edit first student");
            System.out.println("2. Edit last student");
            System.out.println("3. Edit by line number");
            System.out.print("Select an option (1-3): ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    editFirstStudent();
                    break;
                case 2:
                    editLastStudent();
                    break;
                case 3:
                    System.out.print("Enter line number to edit: ");
                    int lineNumber = Integer.parseInt(scanner.nextLine());
                    editByLineNumber(lineNumber);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    showMenu();
                    break;
            }
        }
    }

    private void editFirstStudent() {
        List<Student> students = readStudentsFromFile();
        if (!students.isEmpty()) {
            Student studentToEdit = students.get(0);
            System.out.println("Current details: " + studentToEdit);
            updateStudentDetails(studentToEdit);
            students.set(0, studentToEdit);
            writeStudentsToFile(students);
            System.out.println("First student updated successfully.");
        } else {
            System.out.println("No students to edit.");
        }
    }

    private void editLastStudent() {
        List<Student> students = readStudentsFromFile();
        if (!students.isEmpty()) {
            Student studentToEdit = students.get(students.size() - 1);
            System.out.println("Current details: " + studentToEdit);
            updateStudentDetails(studentToEdit);
            students.set(students.size() - 1, studentToEdit);
            writeStudentsToFile(students);
            System.out.println("Last student updated successfully.");
        } else {
            System.out.println("No students to edit.");
        }
    }

    private void editByLineNumber(int lineNumber) {
        List<Student> students = readStudentsFromFile();
        if (lineNumber > 0 && lineNumber <= students.size()) {
            Student studentToEdit = students.get(lineNumber - 1);
            System.out.println("Current details: " + studentToEdit);
            updateStudentDetails(studentToEdit);
            students.set(lineNumber - 1, studentToEdit);
            writeStudentsToFile(students);
            System.out.println("Student at line " + lineNumber + " updated successfully.");
        } else {
            System.out.println("Invalid line number.");
        }
    }

    private void updateStudentDetails(Student student) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter new name (current: " + student.getName() + "): ");
            String newName = scanner.nextLine();

            System.out.print("Enter new age (current: " + student.getAge() + "): ");
            String newAgeInput = scanner.nextLine();

            if (!newAgeInput.isEmpty()) {
                int newAge = Integer.parseInt(newAgeInput);
                student.setAge(newAge);
            }

            if (!newName.isEmpty()) {
                student.setName(newName);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid age input. Keeping current age.");
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