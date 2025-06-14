package service;

import dao.CarDAO;
import entity.Car;
import java.util.*;

public class CarService {
    private CarDAO carDAO;
    private List<Car> cars;

    public CarService() {
        carDAO = new CarDAO();
        cars = carDAO.loadCars();
    }

    // Add new car
    public void addCar(int id, String brand, String model) {
        if (brand == null || brand.trim().isEmpty() || model == null || model.trim().isEmpty()) {
            System.out.println("Brand and Model cannot be empty.");
            return;
        }

        for (Car c : cars) {
            if (c.getId() == id) {
                System.out.println("❌ Car with this ID already exists.");
                return;
            }
        }

        cars.add(new Car(id, brand, model, true));
        carDAO.saveCars(cars);
        System.out.println("✅ Car added successfully!");
    }

    // View all cars
    public void viewCars() {
        if (cars.isEmpty()) {
            System.out.println("ℹ️ No cars available.");
            return;
        }

        System.out.println("\n--- Available Cars ---");
        for (Car car : cars) {
            System.out.println("ID: " + car.getId() +
                               ", Brand: " + car.getBrand() +
                               ", Model: " + car.getModel() +
                               ", Available: " + (car.isAvailable() ? "Yes" : "No"));
        }
    }

    // Rent a car by ID
    public void rentCar(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                if (!car.isAvailable()) {
                    System.out.println("❌ Car is already rented.");
                    return;
                }
                car.setAvailable(false);
                carDAO.saveCars(cars);
                System.out.println("✅ Car rented successfully!");
                return;
            }
        }
        System.out.println("❌ Invalid Car ID.");
    }

    // Return a car by ID
    public void returnCar(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                if (car.isAvailable()) {
                    System.out.println("❌ Car is already available.");
                    return;
                }
                car.setAvailable(true);
                carDAO.saveCars(cars);
                System.out.println("✅ Car returned successfully!");
                return;
            }
        }
        System.out.println("❌ Invalid Car ID.");
    }

    // Delete a car by ID
    public void deleteCar(int id) {
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            if (car.getId() == id) {
                iterator.remove();
                carDAO.saveCars(cars);
                System.out.println("✅ Car deleted successfully!");
                return;
            }
        }
        System.out.println("❌ Car ID not found.");
    }
}
