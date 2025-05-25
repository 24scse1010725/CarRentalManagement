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

    public void addCar(int id, String brand, String model) {
        for (Car c : cars) {
            if (c.getId() == id) {
                System.out.println("Car with this ID already exists.");
                return;
            }
        }
        cars.add(new Car(id, brand, model, true));
        carDAO.saveCars(cars);
        System.out.println("Car added successfully!");
    }

    public void viewCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
            return;
        }
        for (Car car : cars) {
            System.out.println("ID: " + car.getId() +
                               ", Brand: " + car.getBrand() +
                               ", Model: " + car.getModel() +
                               ", Available: " + car.isAvailable());
        }
    }

    public void rentCar(int id) {
        for (Car car : cars) {
            if (car.getId() == id && car.isAvailable()) {
                car.setAvailable(false);
                carDAO.saveCars(cars);
                System.out.println("Car rented successfully!");
                return;
            }
        }
        System.out.println("Car not available or invalid ID.");
    }

    public void returnCar(int id) {
        for (Car car : cars) {
            if (car.getId() == id && !car.isAvailable()) {
                car.setAvailable(true);
                carDAO.saveCars(cars);
                System.out.println("Car returned successfully!");
                return;
            }
        }
        System.out.println("Invalid Car ID or car is already available.");
    }

    public void deleteCar(int id) {
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            if (car.getId() == id) {
                iterator.remove();
                carDAO.saveCars(cars);
                System.out.println("Car deleted successfully!");
                return;
            }
        }
        System.out.println("Car ID not found.");
    }
}
