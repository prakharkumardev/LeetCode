package designpattern.creational.Factory.normalFactory;

import javax.swing.text.html.Option;
import javax.xml.crypto.Data;
import java.util.Objects;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Database database = DatabaseFactory.getDatabase("mysql");
        database.connect();
        database.disconnect();

        Database database2 = DatabaseFactory.getDatabase("graphql");
        database2.connect();
        database2.disconnect();

        Database database3 = new MongoDbDatabase();
        database3.connect();
        database3.disconnect();







    }
}
