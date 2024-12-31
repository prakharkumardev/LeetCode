package vendingMachine.observer;

import vendingMachine.eventType.EventType;

public interface Subject<T> {
    void subscribe(Observer<T> observer);
    void unsubscribe(Observer<T> observer);
    void notifyObservers(EventType eventType, T message);
}
