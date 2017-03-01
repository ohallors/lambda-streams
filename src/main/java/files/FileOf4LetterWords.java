package files;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 4 letter words, uppercase, without repeats, alphabetical order
 */
public class FileOf4LetterWords {
    public static void main(String[] args) throws Exception {
        String inputFile = "src/main/resources/popular.txt";
        String outputFile = "src/main/resources/four-letter-words.txt";
        int length = 4;
        List<String> words =
                Files.lines(Paths.get(inputFile))
                .filter(word -> word.length() == length)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        Files.write(Paths.get(outputFile), words, Charset.defaultCharset());
        System.out.printf("Wrote %s words to %s.%n", words.size(), outputFile);
    }
}
