package loggerSystem.observer;

public class FileLogger implements LogObserver {
    public void logMessage(String message) {
        System.out.println("File Logger: " + message);
    }
}
