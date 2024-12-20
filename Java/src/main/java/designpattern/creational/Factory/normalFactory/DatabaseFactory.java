package designpattern.creational.Factory.normalFactory;

public class DatabaseFactory {
    public static Database getDatabase(String type) {
        switch (type.toLowerCase()) {
            case "mysql":
                return new MySQLDatabase();
            case "mongodb":
                return new MongoDbDatabase();
            case "graphql":
                return new GraphQLDatabase();
            default:
                return null;
        }
    }
}
