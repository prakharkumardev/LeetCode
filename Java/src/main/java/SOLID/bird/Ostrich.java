package SOLID.bird;

public class Ostrich extends Bird implements Eat{


    private MakeSound sound ;
    private Ostrich(){};
    public Ostrich(MakeSound sound){
        this.sound = sound;
    }

    @Override
    public void eat() {
        System.out.println("Eating grain");
    }

    public void birdSound(){
        sound.makeSound();
    }
}
