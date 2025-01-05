package collection.failSaftFailFast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastList {
    public static void main(String[] args) {
        List<String>  list = new ArrayList<>();
        list.add("a");
        list.add("b");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element);
            list.add("c");
        }
    }
}
