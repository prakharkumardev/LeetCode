package designpattern.structural.decorator;

// Concrete Component: Basic Coffee
class BasicCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public double getCost() {
        return 5.0; // Base cost of coffee
    }
}
