package loggerSystem.observer;

public class DatabaseLogger implements LogObserver {
    @Override
    public void logMessage(String message) {
        System.out.println("Database Logger: " + message);
    }
}
