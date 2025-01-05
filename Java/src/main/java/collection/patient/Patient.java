package collection.patient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Comparator;

@Setter
@Getter
@ToString
public class Patient implements Comparable<Patient> {
    private String name;
    private double age;
    private PatientType patientType;

    public Patient(String name, double age) {
        this.name = name;
        this.age = age;
        if(age<1){
            this.patientType = PatientType.INFANT;
        }else if(age>=1 && age<13){
            this.patientType = PatientType.CHILD;
        }else if(age>=13 && age<65){
            this.patientType = PatientType.ADULT;
        }else if(age>=65){
            this.patientType = PatientType.OLDER_ADULT;
        }
    }

    @Override
    public int compareTo(Patient o) {
        //compare and sort in patient type order with INFANT, CHILD, ADULT, OLDER_ADULT
        return this.patientType.compareTo(o.patientType);
    }
}
