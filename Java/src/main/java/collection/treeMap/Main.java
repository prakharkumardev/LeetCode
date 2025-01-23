package collection.treeMap;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // Example using a TreeMap with a custom comparator
        TreeMap<Student, String> studentTreeMap = new TreeMap<>(new StudentComperator());

        // Add students
        studentTreeMap.put(new Student(1, "Alice"), "Grade A");
        studentTreeMap.put(new Student(3, "Charlie"), "Grade B");
        studentTreeMap.put(new Student(2, "Bob"), "Grade A");
        studentTreeMap.put(new Student(2, "David"), "Grade C"); // Same ID as Bob, different name

        // Print the TreeMap
        System.out.println("TreeMap using Custom Comparator:");
        for (var entry : studentTreeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

//        // Example using natural ordering by implementing Comparable
//        TreeMap<Student, String> naturalOrderMap = new TreeMap<>();
//        naturalOrderMap.put(new Student(1, "Alice"), "Grade A");
//        naturalOrderMap.put(new Student(3, "Charlie"), "Grade B");
//        naturalOrderMap.put(new Student(2, "Bob"), "Grade A");
//        naturalOrderMap.put(new Student(2, "David"), "Grade C");
//
//        System.out.println("\nTreeMap using Natural Ordering:");
//        for (var entry : naturalOrderMap.entrySet()) {
//            System.out.println(entry.getKey() + " -> " + entry.getValue());
//        }
    }
}
