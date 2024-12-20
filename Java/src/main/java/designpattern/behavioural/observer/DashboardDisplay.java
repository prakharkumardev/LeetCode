package designpattern.behavioural.observer;

// Concrete Observer: Dashboard Display
class DashboardDisplay implements WeatherObserver {
    @Override
    public void update(double temperature, double humidity, double pressure) {
        System.out.println("Dashboard Display: Weather Updated - Temp: " + temperature +
                "°C, Humidity: " + humidity + "%, Pressure: " + pressure + " hPa");
    }
}
