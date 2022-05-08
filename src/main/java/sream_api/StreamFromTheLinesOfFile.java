package sream_api;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Stream;

/**
* Extract line from file with stream api
* use try catch for close file
* */

public class StreamFromTheLinesOfFile {
    public static void main(String[] args) throws URISyntaxException {

        URI file = Objects.requireNonNull(
                StreamFromTheLinesOfFile.class.getClassLoader()
                        .getResource("debug.log")).toURI();

        try(Stream<String> lines = Files.lines(Path.of(file))) {
            long warnings = lines.filter(line -> line.contains("WARNING")).count();
            System.out.println("Number of warnings " + warnings);
        } catch (IOException e) {
            System.out.println("ERROR MESSAGE: " + e.getMessage());
        }
    }
}
