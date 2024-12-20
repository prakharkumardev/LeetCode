package designpattern.creational.Factory.normalFactory;

public class GraphQLDatabase implements Database {

    @Override
    public void connect() {
        System.out.println("connect graphql database");
    }

    @Override
    public void disconnect() {
        System.out.println("disconnect graphql database");
    }
}
