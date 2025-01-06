package SOLID;

/*
1. S - Single Responsibility Principle (SRP)

Definition: A class should have only one reason to change, meaning it should only have one job or responsibility.

Benefits:
	•	Reduces the complexity of the class.
	•	Makes the code easier to maintain and test.

Example:
A class for managing employees shouldn’t handle database operations as well. Instead, delegate database-related tasks to a separate class.

2. O - Open/Closed Principle (OCP)

Definition: Software entities (classes, modules, functions) should be open for extension but closed for modification.

Benefits:
	•	Encourages the addition of new functionality without altering existing code.
	•	Reduces the risk of introducing bugs in already-tested code.

Example:
Using interfaces or abstract classes allows adding new implementations without modifying existing ones.
3. L - Liskov Substitution Principle (LSP)

Definition: Subtypes must be substitutable for their base types without altering the correctness of the program.

Benefits:
	•	Ensures polymorphism works as expected.
	•	Promotes reliability in object-oriented designs.

Example:
If Bird is a base class and Penguin is a subclass, calling a method like fly() on a Penguin object should not result in incorrect behavior since penguins don’t fly.

4. I - Interface Segregation Principle (ISP)

Definition: A class should not be forced to implement interfaces it does not use.

Benefits:
	•	Avoids “fat” interfaces and reduces implementation overhead.
	•	Encourages better design by splitting large interfaces into smaller, more specific ones.

Example:
Instead of one large Animal interface with fly(), swim(), and walk(), create specific interfaces like Flyable, Swimmable, and Walkable.

5. D - Dependency Inversion Principle (DIP)

Definition: High-level modules should not depend on low-level modules; both should depend on abstractions. Abstractions should not depend on details; details should depend on abstractions.

Benefits:
	•	Promotes decoupling between components.
	•	Makes the system easier to test and maintain.

Example:
Use dependency injection to inject a DatabaseService interface into a class instead of directly instantiating a MySQLDatabase object.
 */
public class Solid {
}
