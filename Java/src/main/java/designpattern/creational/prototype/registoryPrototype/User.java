package designpattern.creational.prototype.registoryPrototype;

import designpattern.creational.prototype.normalPrototype.Prototype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserPrototype {
    private String name;
    private int age;
    private UserRole role;
    @Override
    public User clone(){
        return new User(this.getName(),this.getAge(),this.getRole());
    }

}
