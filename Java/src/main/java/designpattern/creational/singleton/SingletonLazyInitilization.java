package designpattern.creational.singleton;

public class SingletonLazyInitilization{
    private static SingletonLazyInitilization instance = null;
    private SingletonLazyInitilization(){
    }
    public static SingletonLazyInitilization getInstance(){
        if(instance == null){
            instance = new SingletonLazyInitilization();
        }
        return instance;
    }
}
