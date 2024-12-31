package collection.hashMap;

import java.util.Objects;

public class StudentHashMap {
    private String name;
    private int age;
    private int marks;
    private long id;


    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check reference equality
        if (obj == null || getClass() != obj.getClass()) return false;
        StudentHashMap student = (StudentHashMap) obj;
        return id == student.id && name.equals(student.name); // Logical equality
    }

}
