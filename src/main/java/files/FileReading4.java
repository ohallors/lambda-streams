package files;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Return values Functional Interface
 */
public class FileReading4 {
    public static void main(String[] args) {
        List<String> testWords = Arrays.asList("bog", "bob", "dam", "dad");
        String firstPalindrome = FileReading4.firstPalindrome(testWords.stream());
        System.out.printf("First palindrome %s", firstPalindrome);
    }

    public static String firstPalindrome(Stream<String> words) {
        return words.filter(AllPalindromes::isPalindrome)
                .findFirst()
                .orElse(null);
    }

    public static String firstPalindrome(String fileName) {
        return StreamAnalyzer.analyzeFile(fileName, FileReading4::firstPalindrome);
    }

}
