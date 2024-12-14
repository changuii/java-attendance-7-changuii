package attendance.component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvFileParser implements FileParser {
    @Override
    public List<String> parse(final String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
