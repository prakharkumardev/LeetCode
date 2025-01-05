package loggerSystem;

import loggerSystem.enums.LoggerLevel;
import loggerSystem.observer.LoggerDestination;

public class ErrorLogger extends BaseLogger {

    public ErrorLogger(LoggerLevel level) {
        this.loggerLevel = level;
    }
    @Override
    public void writeMessage(String message, LoggerDestination destination) {
        destination.notifyObservers(LoggerLevel.ERROR, message);
    }
}
