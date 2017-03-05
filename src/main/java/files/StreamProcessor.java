package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by sheamusohalloran on 04/03/2017.
 */
@FunctionalInterface
public interface StreamProcessor {
    void processStream(Stream<String> strings);

    public static void processFile(String filename, StreamProcessor processor) {
        try (Stream<String> line = Files.lines(Paths.get(filename))) {
            processor.processStream(line);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
