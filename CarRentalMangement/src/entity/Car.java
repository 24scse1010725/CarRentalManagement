package entity;

/**
 * Represents a Car with id, brand, model and availability status.
 */
public class Car {
    private int id;
    private String brand;
    private String model;
    private boolean isAvailable;

    /**
     * Constructs a Car.
     * @param id unique positive id of the car
     * @param brand brand name (non-null, non-empty, max 30 chars)
     * @param model model name (non-null, non-empty, max 30 chars)
     * @param isAvailable availability status
     * @throws IllegalArgumentException if parameters are invalid
     */
    public Car(int id, String brand, String model, boolean isAvailable) {
        if (id <= 0) throw new IllegalArgumentException("ID must be positive.");
        if (brand == null || brand.trim().isEmpty() || brand.length() > 30) {
            throw new IllegalArgumentException("Brand must be non-empty and max 30 characters.");
        }
        if (model == null || model.trim().isEmpty() || model.length() > 30) {
            throw new IllegalArgumentException("Model must be non-empty and max 30 characters.");
        }
        this.id = id;
        this.brand = brand.trim();
        this.model = model.trim();
        this.isAvailable = isAvailable;
    }

    public int getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }

    /**
     * Converts this Car to a CSV string.
     */
    @Override
    public String toString() {
        return id + "," + brand + "," + model + "," + isAvailable;
    }

    /**
     * Parses a CSV string to create a Car object.
     * @param data CSV string in format: id,brand,model,isAvailable
     * @return Car object
     * @throws IllegalArgumentException if data format is invalid
     */
    public static Car fromString(String data) {
        if (data == null || data.trim().isEmpty()) {
            throw new IllegalArgumentException("Input data is empty");
        }
        String[] parts = data.split(",");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid data format");
        }
        try {
            int id = Integer.parseInt(parts[0].trim());
            String brand = parts[1].trim();
            String model = parts[2].trim();
            boolean isAvailable = Boolean.parseBoolean(parts[3].trim());
            return new Car(id, brand, model, isAvailable);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format in input data", e);
        }
    }

    /**
     * Equality based on car id.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Car)) return false;
        Car other = (Car) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
