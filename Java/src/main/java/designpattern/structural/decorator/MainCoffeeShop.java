package designpattern.structural.decorator;

/*
Real-World Use Case: Adding Features to a Coffee Ordering System

In a coffee shop system, you might have a base coffee (e.g., Espresso), and customers
can add various features (e.g., milk, sugar, whipped cream). Instead of creating a separate
class for every combination of coffee and features, you can use the
Decorator Design Pattern to dynamically add features.

 */


// Client Code
public class MainCoffeeShop {
    public static void main(String[] args) {
        // Basic coffee
        Coffee coffee = new BasicCoffee();
        System.out.println(coffee.getDescription() + " -> $" + coffee.getCost());

        // Coffee with milk
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " -> $" + coffee.getCost());

        // Coffee with milk and sugar
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " -> $" + coffee.getCost());

        // Coffee with milk, sugar, and whipped cream
        coffee = new WhippedCreamDecorator(coffee);
        System.out.println(coffee.getDescription() + " -> $" + coffee.getCost());
    }
}