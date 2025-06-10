package dao;

import entity.Car;
import java.io.*;
import java.util.*;

public class CarDAO {
    private static final String FILE_NAME = "cars.txt";

    // Load cars from the file
    public List<Car> loadCars() {
        List<Car> cars = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("Note: 'cars.txt' not found. Starting with an empty list.");
            return cars;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    cars.add(Car.fromString(line));
                } catch (Exception e) {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading cars: " + e.getMessage());
        }

        return cars;
    }

    // Save the list of cars to the file
    public void saveCars(List<Car> cars) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Car car : cars) {
                bw.write(car.toString());
                bw.newLine();
            }
            System.out.println("Cars saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving cars: " + e.getMessage());
        }
    }
}

