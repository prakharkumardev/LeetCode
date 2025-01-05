package loggerSystem;

import loggerSystem.enums.LoggerLevel;
import loggerSystem.observer.LoggerDestination;

public abstract class BaseLogger {

    protected LoggerLevel loggerLevel;

    private BaseLogger nextLogger;

    public void setNextLogger(BaseLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(LoggerLevel level, String message, LoggerDestination destination) {
        if(this.loggerLevel.equals(level)) {
            this.writeMessage(message, destination);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message, destination);
        }
    }

    public abstract void writeMessage(String message, LoggerDestination destination);
}
