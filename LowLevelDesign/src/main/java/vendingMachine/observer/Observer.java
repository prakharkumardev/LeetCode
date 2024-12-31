package vendingMachine.observer;

import vendingMachine.eventType.EventType;

@FunctionalInterface
public interface Observer<T> {
    void update(EventType eventType, T message);

}
