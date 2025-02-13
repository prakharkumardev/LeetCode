package java8Features.stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringSum {
    String sum(String... numbers) {
        String[] strings = numbers;
        int sum = 0;

        Long.toString(Arrays.stream(strings).collect(Collectors.summarizingInt(a -> Integer.parseInt(a))).getSum());

//                        reduce("0", (a, b)->Integer.toString(Integer.parseInt(a) + Integer.parseInt(b)));
//


        long sum1 = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();

        var sum2 = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.summarizingInt(value -> value))
                .getSum();

        String.valueOf(sum1);
        String.valueOf(sum2);
        return "0";
    }
}
