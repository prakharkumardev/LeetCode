package java8Features.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergerList {
    public static void main(String[] args) {
        // Two sorted ArrayLists

        List<Integer> list1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8);

        // Merging and sorting using flatMap
        List<Integer> mergedList = Stream.of(list1, list2) // Create a Stream of the lists
                .flatMap(Collection::stream) // Flatten into a single Stream
                .sorted() // Sort the Stream
                .collect(Collectors.toList()); // Collect into a List

        // Print the merged and sorted list
        System.out.println("Merged and Sorted List: " + mergedList);

        
        // Merging and sorting in a single stream operation
        mergedList = Stream.concat(list1.stream(), list2.stream())
                .sorted()
                .collect(Collectors.toList());

        // Print the merged and sorted list
        System.out.println("Merged and Sorted List: " + mergedList);
    }
    }
}
