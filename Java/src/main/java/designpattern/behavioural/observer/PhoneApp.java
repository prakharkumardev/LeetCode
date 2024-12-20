package designpattern.behavioural.observer;

// Concrete Observer: Phone App
class PhoneApp implements WeatherObserver {
    @Override
    public void update(double temperature, double humidity, double pressure) {
        System.out.println("Phone App: Weather Updated - Temp: " + temperature +
                "°C, Humidity: " + humidity + "%, Pressure: " + pressure + " hPa");
    }
}
