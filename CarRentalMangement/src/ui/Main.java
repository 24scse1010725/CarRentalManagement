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

            int choice = InputValidator.readInt(sc, "Enter choice: ", 1, 6);

            switch (choice) {
                case 1 -> {
                    int id = InputValidator.readInt(sc, "Enter Car ID (1-9999): ", 1, 9999);
                    String brand = InputValidator.readValidatedString(sc, "Enter Car Brand: ", 30);
                    String model = InputValidator.readValidatedString(sc, "Enter Car Model: ", 30);
                    carService.addCar(id, brand, model);
                }
                case 2 -> carService.viewCars();
                case 3 -> {
                    int id = InputValidator.readInt(sc, "Enter Car ID to Rent: ", 1, 9999);
                    carService.rentCar(id);
                }
                case 4 -> {
                    int id = InputValidator.readInt(sc, "Enter Car ID to Return: ", 1, 9999);
                    carService.returnCar(id);
                }
                case 5 -> {
                    int id = InputValidator.readInt(sc, "Enter Car ID to Delete: ", 1, 9999);
                    boolean confirmDelete = InputValidator.confirmYesNo(sc, "Are you sure you want to delete this car?");
                    if (confirmDelete) {
                        carService.deleteCar(id);
                    } else {
                        System.out.println("Delete action canceled.");
                    }
                }
                case 6 -> {
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;
                }
            }
        }
    }
}
