package SOLID.bird;

public class LoudSound implements MakeSound{
    @Override
    public void makeSound() {
        System.out.printf("Making Loud Sound");
    }
}
