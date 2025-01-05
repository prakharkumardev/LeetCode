package loggerSystem;

import loggerSystem.enums.LoggerLevel;
import loggerSystem.observer.LoggerDestination;

public class DebugLogger extends BaseLogger {

    public DebugLogger(LoggerLevel level) {
        this.loggerLevel = level;
    }

    @Override
    public void writeMessage(String message, LoggerDestination destination) {
        destination.notifyObservers(LoggerLevel.DEBUG, message);
    }
}
