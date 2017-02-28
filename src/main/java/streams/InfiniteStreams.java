package streams;

import java.util.function.Supplier;
import java.util.stream.Stream;
import model.FibonacciMaker;

/**
 * Must limit infinite streams or they go on forever
 */
public class InfiniteStreams {
    public static void main(String[] args) {
        Supplier<Double> random = Math::random;
        System.out.println("2 random numbers:");
        Stream.generate(random).limit(2).forEach(System.out::println);
        System.out.println("4 random numbers:");
        Stream.generate(random).limit(4).forEach(System.out::println);

        // stateful generator example - risky as not threadsafe
        // lambdas cannot define instance variables so we use a regular class
        // to define the supplier
        Supplier<Long> fibMaker = new FibonacciMaker();
        Stream.generate(fibMaker).limit(16).forEach(System.out::println);
    }

}
