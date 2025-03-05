package StudentAppJson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String FILE_PATH = "F:\\GIT-Push\\IdeaProjects-JAVA\\StudentAppMaven-v3-txt2\\JavaStudentJson\\Students.json";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to Student Management App");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Read students");
            System.out.println("2. Insert new student");
            System.out.println("3. Edit existing student");
            System.out.println("4. Remove student");
            System.out.println("9. Exit the program");

            try {
                System.out.print("Select an option (1-9): ");
                int option = Integer.parseInt(reader.readLine());

                switch (option) {
                    case 1:
                        new Read(FILE_PATH);
                        break;
                    case 2:
                        new Insert(FILE_PATH);
                        break;
                    case 3:
                        new Edit(FILE_PATH);
                        break;
                    case 4:
                        new Remove(FILE_PATH);
                        break;
                    case 9:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Input/Output error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
            }
        }
    }
}