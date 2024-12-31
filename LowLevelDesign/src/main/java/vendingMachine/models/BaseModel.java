package vendingMachine.models;

import lombok.Getter;
import lombok.Setter;
import vendingMachine.observer.Observer;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Setter
@Getter
public abstract class BaseModel {
    private long id;
    private Date createdAt;
    private Date updatedAt;

    public abstract void subscribe(Observer<String> observer);
}
