package roughCode;

class Vehicle {
    String brand;
    int speed;
    String color;

    void initialize(String brand, int speed, String color) {
        this.brand = brand;
        this.speed = speed;
        this.color = color;
    }

    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Color: " + color);
    }
}

class Car extends Vehicle {
    int numberOfDoors;
    String fuelType;
    boolean isAutomatic;

    void initialize(String brand, int speed, String color, int numberOfDoors, String fuelType, boolean isAutomatic) {
        super.initialize(brand, speed, color);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.isAutomatic = isAutomatic;
    }

    void display() {
        super.display();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Automatic: " + isAutomatic);
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.initialize("Toyota", 180, "Red", 4, "Petrol", true);
        myCar.display();
    }
}

