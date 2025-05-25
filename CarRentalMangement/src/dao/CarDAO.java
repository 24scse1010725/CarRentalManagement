
package dao;

import entity.Car;
import java.io.*;
import java.util.*;

public class CarDAO {
    private static final String FILE_NAME = "cars.txt";

    public List<Car> loadCars() {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                cars.add(Car.fromString(line));
            }
        } catch (IOException e) {
            // File may not exist yet; this is fine.
        }
        return cars;
    }

    public void saveCars(List<Car> cars) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Car car : cars) {
                bw.write(car.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving cars: " + e.getMessage());
        }
    }
}
