package collection.treeMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentTreeMap implements Comparable<StudentTreeMap> {
    private int id;
    private final String name;

    public StudentTreeMap(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Implement compareTo() for natural ordering if comperator is not present
    @Override
    public int compareTo(StudentTreeMap other) {
        // Compare by id, then by name
        if (this.id != other.id) {
            return Integer.compare(this.id, other.id);
        }
        return this.name.compareTo(other.name);
    }
}
