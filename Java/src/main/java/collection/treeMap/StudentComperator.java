package collection.treeMap;

import java.util.Comparator;

public class StudentComperator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // Compare by id, then by name
        if (s1.getId() != s2.getId()) {
            return Integer.compare(s1.getId(), s2.getId());
        }
        return s1.getName().compareTo(s2.getName());
    }
}