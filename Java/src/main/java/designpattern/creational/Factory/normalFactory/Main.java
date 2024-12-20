package designpattern.creational.Factory.normalFactory;

public class Main {
    public static void main(String[] args) {
        Database database = DatabaseFactory.getDatabase("mysql");
        database.connect();
        database.disconnect();

        Database database2 = DatabaseFactory.getDatabase("graphql");
        database2.connect();
        database2.disconnect();
    }
}
