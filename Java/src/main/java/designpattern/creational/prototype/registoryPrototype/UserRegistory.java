package designpattern.creational.prototype.registoryPrototype;

public interface UserRegistory {
    User getUserPrototype(UserRole userRole) throws CloneNotSupportedException;
    void registerUser(User user);
}
