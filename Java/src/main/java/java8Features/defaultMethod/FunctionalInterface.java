package java8Features.defaultMethod;


@java.lang.FunctionalInterface
interface FunctionalInterface1 {
    void show();
    //using default you can have multiple method in functional interface
    default void display() {
        System.out.println("Displaying in interface1");
    }

}


@java.lang.FunctionalInterface
interface FunctionalInterface2 {
    void show();
    //using default you can have multiple method in functional interface
    default void display() {
        System.out.println("Displaying in interface2");
    }

}

public class FunctionalInterface implements FunctionalInterface1, FunctionalInterface2 {
    @Override
    public void show() {
        System.out.println("Showing");
    }
    @Override
    public void display() {
        FunctionalInterface1.super.display();
    }

    public static void main(String[] args) {
        FunctionalInterface functionalInterface = new FunctionalInterface();
        functionalInterface.show();
        functionalInterface.display();
    }
}
