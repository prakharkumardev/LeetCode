package designpattern.creational.builder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;
    private String address;
    private int age;
    private String gender;
    private String birthday;
    public static class personBuilder {
        Person person = new Person();
        public personBuilder name(String name) {
            person.name = name;
            return this;
        }
        public personBuilder address(String address) {
            person.address = address;
            return this;
        }
        public personBuilder age(int age) {
            person.age = age;
            return this;
        }
        public personBuilder gender(String gender) {
            person.gender = gender;
            return this;
        }
        public Person builder() {
            return person;
        }
    }

    @Override
    public String toString() {
        return this.name + " " + this.address + " " + this.age + " " + this.gender + " " + this.birthday;
    }

}

class main{
    public static void main(String[] args) {
        Person person = new Person.personBuilder().age(22).address("address").gender("male").name("person").builder();
        System.out.println(person.toString());
    }
}
