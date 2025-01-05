package java8Features.defaultMethod;

public interface Vehicle {

    void stop();
    default void start() {
        System.out.println("Vehicle is starting");
    }
}

class Car implements Vehicle {

    @Override
    public void stop() {
        System.out.println("Car is stopping");
    }
    // you can also oveeride the default method
//    @Override
//    public void start() {
//        System.out.println("Car is starting");
//    }

    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.stop();
    }
}
