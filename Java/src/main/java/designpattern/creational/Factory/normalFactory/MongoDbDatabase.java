package designpattern.creational.Factory.normalFactory;

public class MongoDbDatabase implements Database {

    @Override
    public void connect() {
        System.out.println("connect mongo");
    }

    @Override
    public void disconnect() {
        System.out.println("disconnect mongo");
    }
}
