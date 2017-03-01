package files;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sheamusohalloran on 01/03/2017.
 */
public class WriteFile {
    public static void main(String[] args) throws Exception {
        Charset characterSet = Charset.defaultCharset();
        Path path = Paths.get("src/main/resources/output-file.txt");
        List<String> lines = Arrays.asList("Line 1", "Line 2", "Final line");
        Files.write(path, lines, characterSet);
    }
}
