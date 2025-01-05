package java8Features.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {

        // 1. Predicate<T>: Tests a condition on a given input
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4)); // true

        // 2. BiPredicate<T, U>: Tests a condition on two inputs
        BiPredicate<String, Integer> isLongerThan = (str, len) -> str.length() > len;
        System.out.println("Is 'Hello' longer than 3? " + isLongerThan.test("Hello", 3)); // true

        // 3. Function<T, R>: Applies a transformation on input and returns output
        Function<String, Integer> stringLength = String::length;
        System.out.println("Length of 'Java': " + stringLength.apply("Java")); // 4

        // 4. BiFunction<T, U, R>: Applies a transformation on two inputs and returns output
        BiFunction<Integer, Integer, Integer> add = Integer::sum;
        System.out.println("Sum of 5 and 7: " + add.apply(5, 7)); // 12

        // 5. UnaryOperator<T>: Same as Function<T, R> but input and output types are the same
        UnaryOperator<Integer> square = n -> n * n;
        System.out.println("Square of 5: " + square.apply(5)); // 25

        // 6. BinaryOperator<T>: Same as BiFunction<T, T, T>, operates on two inputs of the same type
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println("Product of 4 and 5: " + multiply.apply(4, 5)); // 20

        // 7. Supplier<T>: Provides a result without any input
        Supplier<Double> random = Math::random;
        System.out.println("Random number: " + random.get());

        // 8. Consumer<T>: Consumes input and performs an operation without returning anything
        Consumer<String> print = System.out::println;
        print.accept("Hello from Consumer!"); // Output: Hello from Consumer!

        // 9. BiConsumer<T, U>: Consumes two inputs and performs an operation without returning anything
        BiConsumer<String, Integer> printKeyValue = (key, value) -> System.out.println(key + ": " + value);
        printKeyValue.accept("Age", 25); // Output: Age: 25

        // Additional Example for Collection Operations
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Predicate with Stream
        System.out.println("Names starting with 'A':");
        names.stream().filter(name -> name.startsWith("A")).forEach(print);

        // Function with Stream
        System.out.println("Lengths of names:");
        names.stream().map(stringLength).forEach(System.out::println);

        // Consumer with forEach
        System.out.println("Printing all names:");
        names.forEach(print);
    }
}
