package objectPooling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.UUID;

public class DBConnection {

    UUID DBConnection;
    public DBConnection() {
        try {
            //DBConnection = DriverManager.getConnection("", "", "password");
            DBConnection = UUID.randomUUID();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
