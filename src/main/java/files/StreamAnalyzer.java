package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by sheamusohalloran on 04/03/2017.
 */
@FunctionalInterface
public interface StreamAnalyzer<T> {
    T analyzeStream(Stream<String> stings);

    public static <T> T analyzeFile(String filename, StreamAnalyzer<T> analyzer) {
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            return analyzer.analyzeStream(lines);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
