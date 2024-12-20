package designpattern.creational.singleton;

public class Singleton {
    private volatile static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstanceDoubleCheclLocking() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}

