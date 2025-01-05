package recordClass;

/*
Key Features:
	1.	Immutable Fields: All fields in a record are final by default.
	2.	Compact Syntax: The record automatically generates:
	•	A constructor.
	•	equals(), hashCode(), and toString() methods.
	•	Getters (named the same as the field, e.g., firstName()).
	3.	Custom Methods: You can add methods like fullName() for additional functionality.
	4.	Validation in Constructor: Add validation logic inside the compact constructor.
 */

public record Person(
        String firstName,
        String lastName,
        int age,
        String email
) {
    // You can add custom methods if needed
    public String fullName() {
        return firstName + " " + lastName;
    }

    // Validation in the canonical constructor
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
    }
}