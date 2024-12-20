package designpattern.behavioural.observer;

// Observer Interface
interface WeatherObserver {
    void update(double temperature, double humidity, double pressure);
}
