package de.exxcellent.challenge.data.file.csv;

import de.exxcellent.challenge.data.DataCollector;
import de.exxcellent.challenge.data.file.FileParser;
import de.exxcellent.challenge.exceptions.DataInaccessibleException;
import de.exxcellent.challenge.models.FootballData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CSVFootballDataParser implements DataCollector<FootballData>, FileParser<FootballData> {

    private final String fileName;

    public CSVFootballDataParser(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<FootballData> getData() throws DataInaccessibleException {
        try {
            return getDataFromFile(path.resolve(this.fileName));
        } catch (FileNotFoundException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new DataInaccessibleException();
        }
    }

    @Override
    public List<FootballData> getDataFromFile(Path path) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(path.toString()));
        return reader.lines()
                .skip(1) // assumes that every .csv data set has a header line that has to be skipped
                .map(line -> line.split(","))
                .map(this::createFootballData)
                .collect(Collectors.toList());
    }

    private FootballData createFootballData(String[] attributes) {
        return new FootballData(attributes[0], Integer.parseInt(attributes[1]), Integer.parseInt(attributes[2]), Integer.parseInt(attributes[3]), Integer.parseInt(attributes[4]), Integer.parseInt(attributes[5]), Integer.parseInt(attributes[6]), Integer.parseInt(attributes[7]));
    }
}
