package objectPooling;

import loggerSystem.Logger;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
public final class DBConnectionPoolManager {
    private List<DBConnection> availableConnections;
    private List<DBConnection> usedConnections;
    private final int initialPoolSize = 3;
    private final int maxPoolSize = 6;
    private static DBConnectionPoolManager instance;
    private DBConnectionPoolManager() {
        // private constructor
        availableConnections = new ArrayList<>();
        usedConnections = new ArrayList<>();

        IntStream.range(0, initialPoolSize).
                forEach(i -> availableConnections.add(new DBConnection()));
    }
    public static DBConnectionPoolManager getInstance() {
        if (instance == null) {
            synchronized (DBConnectionPoolManager.class) {
                if (instance == null)
                    instance = new DBConnectionPoolManager();
            }
        }
        return instance;
    }

    public synchronized DBConnection getDBConnection() {
        if (availableConnections.isEmpty()) {
            if (usedConnections.size() < maxPoolSize) {
                System.out.println("Creating new connection as all connections are used");
                DBConnection dbConnection = new DBConnection();
                usedConnections.add(dbConnection);
                return dbConnection;
            } else {
                throw new RuntimeException("Connection limit exceeded");
            }
        } else {
            DBConnection dbConnection = availableConnections.get(0);
            availableConnections.remove(0);
            usedConnections.add(dbConnection);
            return dbConnection;
        }
    }
    public synchronized void releaseConnection(DBConnection dbConnection) {
        if(dbConnection == null || !usedConnections.contains(dbConnection)) {
            throw new RuntimeException("Invalid connection");
        }
        usedConnections.remove(dbConnection);
        availableConnections.add(dbConnection);
    }
}
