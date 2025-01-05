package loggerSystem;

import loggerSystem.enums.LoggerLevel;
import loggerSystem.observer.ConsoleLogger;
import loggerSystem.observer.FileLogger;
import loggerSystem.observer.LoggerDestination;

public class LogManager {
    public static BaseLogger doChaining(){

        BaseLogger infoLogger = new InfoLogger(LoggerLevel.INFO);
        BaseLogger debugLogger = new DebugLogger(LoggerLevel.DEBUG);
        BaseLogger errorLogger = new ErrorLogger(LoggerLevel.ERROR);

        infoLogger.setNextLogger(errorLogger);
        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(null);
        return infoLogger;
    }
    public static LoggerDestination addObservers(){

        LoggerDestination loggerDestination = new LoggerDestination();
        loggerDestination.addObserver(LoggerLevel.DEBUG,new ConsoleLogger());
        loggerDestination.addObserver(LoggerLevel.INFO, new FileLogger());
        return loggerDestination;
    }
}
