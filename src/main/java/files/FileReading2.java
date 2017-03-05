package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Use same stream method from file or List
 */
public class FileReading2 {
    public static void main(String[] args) {

        System.out.println("From file");
        printAllPalindromes("src/main/resources/popular.txt");
        System.out.println("From List");
        List<String> words = Arrays.asList("dad", "toot", "kayak");
        printAllPalindromes(words.stream());
    }

    public static void printAllPalindromes(String filename) {
        try (Stream<String> line = Files.lines(Paths.get(filename))) {
            printAllPalindromes(line);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static void printAllPalindromes(Stream<String> words) {
        words.filter(AllPalindromes::isPalindrome)
                .forEach(System.out::println);
    }
}
