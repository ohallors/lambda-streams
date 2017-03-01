package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Java used to use Path, Paths with static methods because
 * interfaces couldn't have implementations.
 * That probably wouldn't be the case if we started with Java 8
 */
public class PathClass {
    public static void main(String[] args) {
        Path p1 = Paths.get("src/main/resources/popular.txt");
        System.out.println("Simple path");
        System.out.printf("toString: %s.%n", p1);
        Path p2 = p1.toAbsolutePath();
        System.out.printf("Absolute Path: %s.%n", p2);
        try (Stream<String> lines = Files.lines(p1)) {
            // uses UTF-8 if no charset
            lines.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
