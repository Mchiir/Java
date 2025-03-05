package CAT;

import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
                System.out.print("Enter the tree height: ");
                int height = sc.nextInt();

            // Draw the tree
            for (int i = 0; i < height; i++) {
                // Print spaces
                for (int j = height - i; j > 1; j--) {
                    System.out.print(" ");
                }
                // Print stars
                for (int k = 0; k <= i * 2; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            // Draw the trunk
            for (int i = 0; i < height / 3; i++) {
                for (int j = 0; j < height - 1; j++) {
                    System.out.print(" ");
                }
                System.out.println("||");
            }
        }
    }
}
