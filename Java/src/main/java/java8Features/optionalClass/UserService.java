package java8Features.optionalClass;

import java.util.Optional;

public class UserService {
    public Optional<String> findUserById(int id) {
        // Simulating a database lookup
        if (id == 1) {
            return Optional.of("John Doe");
        } else {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        UserService userService = new UserService();

        // Looking up a user
        Optional<String> user = userService.findUserById(10);
        user.ifPresentOrElse(
                System.out::println, // If user is found
                () -> System.out.println("User not found") // If user is not found
        );


        // Output: John Doe (for id = 1)
        // Output: User not found (for id ≠ 1)
    }
}
