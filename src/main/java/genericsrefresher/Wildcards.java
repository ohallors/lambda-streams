package genericsrefresher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ? means unknown
 */
public class Wildcards {
    public static void main(String[] args) {
        List<?> stuff = Arrays.asList("Hello", LocalDate.now(), 3);
        stuff.size();
        stuff.forEach((Object o) -> System.out.println(o));

        // Can't add to a wildcard list!!!!!!
        // stuff.add("cat")

        // Upper bound wildcards
        // - You can define
        // - You can read from
        // - but you can't add to
        List<? extends Number> numbers = new ArrayList<>();
        // numbers.add(3); fails, you can't add
        // but useful for methods that accept types
        List<Integer> ints = Arrays.asList(5, 6, 7, 8);
        System.out.println(sumList(ints));

        // lower bound wildcards
        List<String> strings = Stream.of("a", "few", "strings")
                .collect(Collectors.toList());

        strings.forEach((String s) -> System.out.printf("%s in all caps is %s%n", s, s.toUpperCase()));
        strings.forEach((Object o) -> System.out.printf("%s has hashcode %s%n", o, o.hashCode()));

        // peek also uses consumer like forEach
        List<Integer> integers = Stream.of(3, 1, 4, 5, 9)
                .peek(i -> System.out.println(i + " as a binary string is " + Integer.toBinaryString(i)))
                .peek((Number n) -> System.out.println("The double value of " + n + " is " + n.doubleValue()))
                .peek((Object o) -> System.out.println("The default hashcode of " + o + " is " + o.hashCode()))
                .collect(Collectors.toList());
        System.out.println(integers);
    }

    public static double sumList(List<? extends Number> list) {
        return list.stream()
                .mapToDouble(Number::doubleValue)
                .sum();
    }
}
