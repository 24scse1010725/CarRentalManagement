package ui;

import service.CarService;
import utils.InputValidator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CarService carService = new CarService();

        while (true) {
            System.out.println("\n=== Car Rental System ===");
            System.out.println("1. Add Car");
            System.out.println("2. View Cars");
            System.out.println("3. Rent Car");
            System.out.println("4. Return Car");
            System.out.println("5. Delete Car");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            
            int choice = InputValidator.readInt(sc, "");

            switch (choice) {
                case 1 -> {
                    int id = InputValidator.readInt(sc, "Enter Car ID: ");
                    String brand = InputValidator.readNonEmptyString(sc, "Enter Car Brand: ");
                    String model = InputValidator.readNonEmptyString(sc, "Enter Car Model: ");
                    carService.addCar(id, brand, model);
                }
                case 2 -> carService.viewCars();
                case 3 -> {
                    int id = InputValidator.readInt(sc, "Enter Car ID to Rent: ");
                    carService.rentCar(id);
                }
                case 4 -> {
                    int id = InputValidator.readInt(sc, "Enter Car ID to Return: ");
                    carService.returnCar(id);
                }
                case 5 -> {
                    int id = InputValidator.readInt(sc, "Enter Car ID to Delete: ");
                    carService.deleteCar(id);
                }
                case 6 -> {
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
