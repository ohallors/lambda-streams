import java.util.Arrays;

/**
 * Created by sheamusohalloran on 28/01/2017.
 */
public class Example1 {
    String[] testStrings = {"one", "two", "three", "four"};

    public static void main(String[] args) {
        new Example1().sort();
    }

    void sort() {
        Arrays.sort(testStrings, (s1, s2) -> s1.length() - s2.length());
        Arrays.stream(testStrings).forEach(System.out::println);
    }
}
