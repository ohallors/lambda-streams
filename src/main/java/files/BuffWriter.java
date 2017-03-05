package files;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by sheamusohalloran on 01/03/2017.
 */
public class BuffWriter {
    public static void main(String[] args) throws IOException {
        Charset characterSet = Charset.defaultCharset();
        int numLines = 10;

        Path path = Paths.get("src/main/resources/output-file-2.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path, characterSet)) {
            for (int i = 0; i < numLines; i++) {
                writer.write("Number is " + 100 * Math.random());
                writer.newLine();
            }
        }

        // printwriter is easier to use
        Path path2 = Paths.get("src/main/resources/output-file-3.txt");
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(path2, characterSet))) {
            for (int i = 0; i < numLines; i++) {
                out.printf("Number is %8.2f%n", 100 * Math.random());
            }
        }
    }
}
