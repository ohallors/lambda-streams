package files;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Create functional interface for writing out to a file called
 * StreamProcessor which removes need for files boilerplate
 */
public class FileReading3 {
    public static void main(String[] args) {
//        printAllPalindromes("src/main/resources/popular.txt");

        List<String> words = Arrays.asList("dad", "toot", "kayak");
        printAllPalindromes(words.stream());
        System.out.println("5 letter palindromes");
        printPalindromes("src/main/resources/popular.txt", 5);
    }

    // easy example, printAllPalindromes implements StreamProcessor Interface
    public static void printAllPalindromes(String fileName) {
        StreamProcessor.processFile(fileName, FileReading3::printAllPalindromes);
    }

    public static void printAllPalindromes(Stream<String> words) {
        words.filter(AllPalindromes::isPalindrome)
                .forEach(System.out::println);
    }

    public static void printPalindromes(Stream<String> words, int length) {
        words.filter(word -> word.length() == length)
                .filter(AllPalindromes::isPalindrome)
                .forEach(System.out::println);
    }

    // Harder example, the Lambda being passed matches the StreamProcessor interface
    public static void printPalindromes(String fileName, int length) {
        StreamProcessor.processFile(fileName, lines -> printPalindromes(fileName, length));
    }

}
