package utils;

import java.util.Scanner;

public class InputValidator {
    public static int readInt(Scanner sc, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine();
                return value;
            } else {
                System.out.println("Invalid input! Enter a valid number.");
                sc.nextLine();
            }
        }
    }

    public static String readNonEmptyString(Scanner sc, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Input cannot be empty.");
        }
    }
}
