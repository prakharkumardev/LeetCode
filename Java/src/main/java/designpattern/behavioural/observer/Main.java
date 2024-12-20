package designpattern.behavioural.observer;
/*
Real-World Use Case: Weather Monitoring System

In a weather monitoring system, multiple devices (like phone apps, weather dashboards,
and alert systems) need to receive updates whenever the weather data changes.
The Observer Design Pattern is ideal for this scenario because it allows the system
to notify all registered observers (subscribers) automatically when the subject (weather data) changes.
 */

// Client Code
public class Main {
    public static void main(String[] args) {
        // Create the subject
        WeatherData weatherData = new WeatherData();

        // Create observers
        WeatherObserver phoneApp = new PhoneApp();
        WeatherObserver dashboardDisplay = new DashboardDisplay();
        WeatherObserver alertSystem = new AlertSystem();

        // Register observers
        weatherData.registerObserver(phoneApp);
        weatherData.registerObserver(dashboardDisplay);
        weatherData.registerObserver(alertSystem);

        // Simulate weather updates
        System.out.println("First Update:");
        weatherData.setWeatherData(30.5, 65.0, 1013.0);

        System.out.println("\nSecond Update:");
        weatherData.setWeatherData(36.0, 70.0, 1010.0);
    }
}
