package entity;

public class Car {
    private int id;
    private String brand;
    private String model;
    private boolean isAvailable;

    public Car(int id, String brand, String model, boolean isAvailable) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return id + "," + brand + "," + model + "," + isAvailable;
    }

    public static Car fromString(String data) {
        String[] parts = data.split(",");
        return new Car(
            Integer.parseInt(parts[0]),
            parts[1],
            parts[2],
            Boolean.parseBoolean(parts[3])
        );
    }
}
