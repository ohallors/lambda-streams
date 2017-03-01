package files;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by sheamusohalloran on 28/02/2017.
 */
public class AllPalindromes {
    public static void main(String[] args) throws Exception {
        String inputFile = "src/main/resources/popular.txt";
        Files.lines(Paths.get(inputFile))
                .filter(AllPalindromes::isPalindrome)
                .forEach(System.out::println);

        // alpha first palindrome that is 6 letters long
        // 6 was null, going for 5
        String firstPalindrome =
                Files.lines(Paths.get(inputFile))
                .filter(word -> word.length() == 5)
                .filter(AllPalindromes::isPalindrome)
                .sorted()
                .findFirst()
                .orElse(null);
        System.out.printf("First six letter palindrome is %s.%n", firstPalindrome);
    }

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static boolean isPalindrome(String s) {
        return s.equalsIgnoreCase(reverseString(s));
    }
}
