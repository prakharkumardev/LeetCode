package designpattern.behavioural.observer;

// Concrete Observer: Alert System
class AlertSystem implements WeatherObserver {
    @Override
    public void update(double temperature, double humidity, double pressure) {
        if (temperature > 35.0) {
            System.out.println("Alert System: Heat Alert! Temperature is " + temperature + "°C");
        }
    }
}
