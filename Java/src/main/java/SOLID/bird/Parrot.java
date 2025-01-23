package SOLID.bird;

public class Parrot extends Bird implements Fly, Eat{


    private MakeSound sound ;
    private Parrot(){};
    public Parrot(MakeSound sound){
        this.sound = sound;
    }

    @Override
    public void eat() {
        System.out.println("Eating Chilly");
    }

    @Override
    public void birdFly() {
        System.out.println("Flying in lower sky");
    }

    public void birdSound(){
        sound.makeSound();
    }

}
