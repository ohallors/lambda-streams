package files;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by sheamusohalloran on 28/02/2017.
 */
public class LengthOfAllXYWords {
    public static void main(String[] args) throws Exception {
        String inputFile = "src/main/resources/popular.txt";
        int letterCount = Files.lines(Paths.get(inputFile))
                .filter(word -> word.contains("x"))
                .filter(word -> word.contains("y"))
                .mapToInt(String::length)
                .sum();
        System.out.printf("%,d total letters in words with both x and y.%n", letterCount);
    }
}
