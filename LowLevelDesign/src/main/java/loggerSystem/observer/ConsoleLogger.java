package loggerSystem.observer;

public class ConsoleLogger implements LogObserver {
    @Override
    public void logMessage(String message) {
        System.out.println("Console Logger: " + message);
    }
}
