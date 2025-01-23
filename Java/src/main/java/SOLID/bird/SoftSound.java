package SOLID.bird;

public class SoftSound implements MakeSound{
    @Override
    public void makeSound() {
        System.out.println("Making soft sound");
    }
}
