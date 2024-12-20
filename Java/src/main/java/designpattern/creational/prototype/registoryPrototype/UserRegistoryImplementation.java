package designpattern.creational.prototype.registoryPrototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRegistoryImplementation implements UserRegistory {

    Map<UserRole, User> userList = new HashMap<>();
    @Override
    public User getUserPrototype(UserRole userRole) {
        return userList.get(userRole).clone();
    }

    @Override
    public void registerUser(User user) {
        userList.put(user.getRole(), user);
    }
}
class Main{
    public static void main(String[] args){
        User student = new User("student name", 20, UserRole.Student);
        User teacher = new User("teacher name", 30, UserRole.Teacher);
        User admin = new User("admin name", 40, UserRole.Admin);

        UserRegistoryImplementation implementation = new UserRegistoryImplementation();
        implementation.registerUser(student);
        implementation.registerUser(teacher);
        implementation.registerUser(admin);

        User studentPrototype = implementation.getUserPrototype(UserRole.Student);
        User teacherPrototype = implementation.getUserPrototype(UserRole.Teacher);
        User adminPrototype = implementation.getUserPrototype(UserRole.Admin);
        System.out.println(studentPrototype);
        System.out.println(teacherPrototype);
        System.out.println(adminPrototype);
    }
}
