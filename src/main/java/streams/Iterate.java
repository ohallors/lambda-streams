package streams;

import java.util.List;
import java.util.stream.*;

/**
 * Created by sheamusohalloran on 28/02/2017.
 */
public class Iterate {
    public static void main(String[] args) {
        List<Integer> powersOfTwo = Stream.iterate(1, n -> n * 2)
                .limit(35)
                .collect(java.util.stream.Collectors.toList());
        powersOfTwo.forEach(System.out::println);
    }
}
