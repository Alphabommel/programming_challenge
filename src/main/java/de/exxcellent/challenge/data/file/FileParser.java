package de.exxcellent.challenge.data.file;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.List;

public interface FileParser<T> {
    Path path = Path.of("src/main/resources/de/exxcellent/challenge/");

    List<T> getDataFromFile(Path path) throws FileNotFoundException;
}
