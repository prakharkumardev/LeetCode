package designpattern.behavioural.observer;

// Subject Interface
interface WeatherSubject {
    void registerObserver(WeatherObserver observer);

    void removeObserver(WeatherObserver observer);

    void notifyObservers();
}
