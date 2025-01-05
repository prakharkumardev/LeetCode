package loggerSystem.observer;

import loggerSystem.enums.LoggerLevel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoggerDestination {
    private final Map<LoggerLevel, List<LogObserver>> logObservers = new HashMap<>();

    public void addObserver(LoggerLevel level, LogObserver observer) {
        if(logObservers.containsKey(level))  logObservers.get(level).add(observer);
        else logObservers.put(level, List.of(observer));
    }

    public void removeObserver(LoggerLevel level, LogObserver observer) {
        logObservers.get(level).remove(observer);
    }

    public void notifyObservers(LoggerLevel level, String message) {
        if(!logObservers.containsKey(level)) return;
        for (LogObserver observer : logObservers.get(level)) {
            message = level.toString() + ": " + message;
            observer.logMessage(message);
        }
    }

}
