package loggerSystem;

import loggerSystem.enums.LoggerLevel;
import loggerSystem.observer.LoggerDestination;

import java.util.logging.Level;

public class Logger {
    private static Logger loggerInstance;
    private static BaseLogger chainOfLogger;
    private static LoggerDestination loggerDestination;
    private Logger() {
        if (loggerInstance != null) {
            throw new RuntimeException("Use getLogger() method to get the single instance of this class.");
        }
    }
    public static Logger getLogger(){
        if(loggerInstance == null){
            synchronized (Logger.class){
                if(loggerInstance == null){
                    loggerInstance = new Logger();
                    chainOfLogger = LogManager.doChaining();
                    loggerDestination = LogManager.addObservers();
                }
            }
        }
        return loggerInstance;
    }

    public void info(String message){
        createLog(LoggerLevel.INFO, message);
    }
    public void debug(String message){
        createLog(LoggerLevel.DEBUG, message);
    }
    public void error(String message){
        createLog(LoggerLevel.ERROR, message);
    }
    private void createLog(LoggerLevel level, String message){
        chainOfLogger.logMessage(level,message,loggerDestination);
        //chainOfLogger.logMessage(level, message, loggerDestination)

    }

}
