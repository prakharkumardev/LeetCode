package collection.patient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient("John", 25));
        patients.add(new Patient("Jane", 5));
        patients.add(new Patient("Doe", 75));
        patients.add(new Patient("Smith", 1));
        patients.add(new Patient("Doe", 65));
        patients.add(new Patient("Smith", 13));
        patients.add(new Patient("Doe", 0.5));
        patients.add(new Patient("Smith", 0.5));


        patients.sort((p1, p2) -> Double.compare(p2.getAge(), p1.getAge()));
        System.out.println("Patients sorted by age:");
        patients.forEach(System.out::println);
        Collections.sort(patients);
        System.out.println("Patients sorted by patient type:" );
        patients.forEach(System.out::println);
    }
}
