package recordClass;

public class RecordRunExample {
    public static void main(String[] args) {
        // Create a Person record
        Person person = new Person("John", "Doe", 30, "john.doe@example.com");

        // Access fields
        System.out.println("First Name: " + person.firstName());
        System.out.println("Last Name: " + person.lastName());
        System.out.println("Age: " + person.age());
        System.out.println("Email: " + person.email());
        System.out.println("Full Name: " + person.fullName());

        // Records automatically generate a clean toString()
        System.out.println("Person Details: " + person);

        // Equality check
        Person anotherPerson = new Person("John", "Doe", 30, "john.doe@example.com");
        System.out.println("Is Equal: " + person.equals(anotherPerson));
    }

}
