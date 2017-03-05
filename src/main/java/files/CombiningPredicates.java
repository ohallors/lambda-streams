package files;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by sheamusohalloran on 04/03/2017.
 */
public class CombiningPredicates {
    public static void main(String[] args) {
        List<String> testWords = Arrays.asList("hi", "hello", "hola");
        System.out.printf("In list %s.%n", testWords);
        int sum1 = letterCount(testWords.stream(),
                                word -> word.contains("h"),
                                word -> !word.contains("i"));
        printResult(sum1, "contain h but not i");

        int sum2 = letterCount("src/main/resources/popular.txt", AllPalindromes::isPalindrome);
        printResult(sum2, "are palindromes");
        int sum3 = letterCount("src/main/resources/popular.txt",
                                word -> word.contains("q"),
                                word -> !word.contains("qu"));
        printResult(sum3, "contain q but not qu");

        int sum4 = letterCount("src/main/resources/popular.txt", word -> true);
        printResult(sum4, "are in english language");
    }

    public static <T> void printResult(T val, String text) {
        System.out.printf("%d %s.%n", val, text);
    }

    @SafeVarargs
    public static Integer letterCount(String filename, Predicate<String>... tests) {
        return StreamAnalyzer.analyzeFile(filename, stream -> letterCount(stream, tests));
    }

    @SafeVarargs
    public static int letterCount(Stream<String> words, Predicate<String>... tests) {
        Predicate<String> combinedTest = combinedPredicate(tests);
        return words.filter(combinedTest)
                .mapToInt(String::length)
                .sum();
    }

    @SafeVarargs
    public static <T> Predicate<T> combinedPredicate(Predicate<T>... tests) {
        Predicate<T> result = e -> true;

        for (Predicate<T> test : tests) {
            result = result.and(test);
        }
        return result;
    }
}
