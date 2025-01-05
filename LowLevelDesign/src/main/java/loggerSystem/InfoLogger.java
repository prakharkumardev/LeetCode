package loggerSystem;

import loggerSystem.enums.LoggerLevel;
import loggerSystem.observer.LoggerDestination;

public class InfoLogger extends BaseLogger {

    public InfoLogger(LoggerLevel loggerLevel) {
        this.loggerLevel = loggerLevel;
    }

    @Override
    public void writeMessage(String message, LoggerDestination destination) {
        destination.notifyObservers(LoggerLevel.INFO,message);
    }
}
