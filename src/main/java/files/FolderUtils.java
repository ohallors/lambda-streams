package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by sheamusohalloran on 01/03/2017.
 */
public class FolderUtils {

    public static void main(String[] args) {
        System.out.println("Text files in project root");
        printAllPathsInFolder(".", path -> path.toString().endsWith(".txt"));
        System.out.println("Text files in project tree");
        printPathsInTree(".", path -> path.toString().endsWith(".txt"));
        System.out.println("Text files in project tree");
        findPathsInTree(".", (path, attrs) -> attrs.isDirectory());
    }

    public static void printAllPaths(Stream<Path> paths) {
        paths.forEach(System.out::println);
    }

    public static void printAllPaths(Stream<Path> paths, Predicate<Path> test) {
        paths.filter(test).forEach(System.out::println);
    }

    public static void printAllPathsInFolder(String folder, Predicate<Path> test) {
        try (Stream<Path> paths = Files.list(Paths.get(folder))) {
            printAllPaths(paths, test);
        } catch (IOException ioe) {
            System.err.println("IOException " + ioe);
        }
    }

    public static void printAllPathsInTree(String rootFolder) {
        try (Stream<Path> paths = Files.walk(Paths.get(rootFolder))) {
            printAllPaths(paths);
        } catch (IOException ioe) {
            System.err.println("IOException " + ioe);
        }
    }

    public static void printPathsInTree(String rootFolder, Predicate<Path> test) {
        try (Stream<Path> paths = Files.walk(Paths.get(rootFolder))) {
            printPaths(paths, test);
        } catch (IOException ioe) {
            System.err.println("IOException " + ioe);
        }
    }

    public static void printPaths(Stream<Path> paths, Predicate<Path> test) {
        paths.filter(test).forEach(System.out::println);
    }

    public static void findPathsInTree(String rootFolder, BiPredicate<Path, BasicFileAttributes> test) {
        try (Stream<Path> paths = Files.find(Paths.get(rootFolder), 10, test)) {
            printAllPaths(paths);
        } catch (IOException ioe) {
            System.err.println("IOException " + ioe);
        }
    }
}
