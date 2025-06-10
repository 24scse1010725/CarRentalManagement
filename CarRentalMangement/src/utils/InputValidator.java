package utils;

import java.util.Scanner;

public class InputValidator {

    public static int readInt(Scanner sc, String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine(); // consume newline
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.printf("Input must be between %d and %d.%n", min, max);
                }
            } else {
                System.out.println("Invalid input! Enter a valid number.");
                sc.nextLine(); // consume invalid input
            }
        }
    }

    public static String readValidatedString(Scanner sc, String prompt, int maxLength) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty.");
            } else if (input.length() > maxLength) {
                System.out.println("Input too long. Maximum length is " + maxLength + " characters.");
            } else if (!input.matches("[a-zA-Z0-9 ]+")) {
                System.out.println("Input can only contain letters, numbers, and spaces.");
            } else {
                return input;
            }
        }
    }

    public static boolean confirmYesNo(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt + " (Y/N): ");
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("y")) return true;
            else if (input.equals("n")) return false;
            else System.out.println("Please enter Y or N.");
        }
    }
}
