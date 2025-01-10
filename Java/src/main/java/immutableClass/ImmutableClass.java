package immutableClass;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableClass {

    private final int value;
    private final List<Integer> list;

    public ImmutableClass(int value, List<Integer> list) {
        this.value = value;
        this.list = new ArrayList<>(list);  //make sure to create a new list, as the list passed in could be modified
    }
    //immutable method
    public int getValue() {
        return value;
    }
    //returning a new arraylist to ensure that the list remains immutable
    public List<Integer> getList() {
        return new ArrayList<>(list);
    }
    //immutable method
    public ImmutableClass addItem(int listValue){
        List<Integer> newList = new ArrayList<>(list);
        newList.add(listValue);
        return new ImmutableClass(value, newList);
    }
}
