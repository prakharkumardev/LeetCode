package objectPooling;

public class Client {
    public static void main(String[] args) {
        DBConnectionPoolManager dbConnectionPoolManager = DBConnectionPoolManager.getInstance();
        DBConnection dbConnection1 = dbConnectionPoolManager.getDBConnection();
        DBConnection dbConnection2 = dbConnectionPoolManager.getDBConnection();
        DBConnection dbConnection3 = dbConnectionPoolManager.getDBConnection();
        dbConnectionPoolManager.releaseConnection(dbConnection1);
        DBConnection dbConnection4 = dbConnectionPoolManager.getDBConnection();


    }
}
