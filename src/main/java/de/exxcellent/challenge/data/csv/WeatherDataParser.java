package de.exxcellent.challenge.data.csv;

import de.exxcellent.challenge.data.DataCollector;
import de.exxcellent.challenge.exceptions.DataInaccessibleException;
import de.exxcellent.challenge.models.WeatherData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherDataParser implements DataCollector<WeatherData> {

    private final String fileName;
    private final Path path = Path.of("src/main/resources/de/exxcellent/challenge/");
    public WeatherDataParser(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<WeatherData> getData() throws DataInaccessibleException {
        try {
            return getDataFromFile(path.resolve(this.fileName));
        } catch (FileNotFoundException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new DataInaccessibleException();
        }
    }

    public List<WeatherData> getDataFromFile(Path path) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(path.toString()));
        return reader.lines()
                .skip(1) // assumes that every .csv data set has a header line that has to be skipped
                .map(line -> line.split(","))
                .map(this::createWeatherData)
                .collect(Collectors.toList());
    }

    private WeatherData createWeatherData(String[] attributes) {
        return new WeatherData(Integer.parseInt(attributes[0]), Integer.parseInt(attributes[1]), Integer.parseInt(attributes[2]), Integer.parseInt(attributes[3]), Double.parseDouble(attributes[4]), Integer.parseInt(attributes[5]), Integer.parseInt(attributes[6]), Double.parseDouble(attributes[7]), Integer.parseInt(attributes[8]), Integer.parseInt(attributes[9]), Double.parseDouble(attributes[10]), Integer.parseInt(attributes[11]), Integer.parseInt(attributes[12]), Double.parseDouble(attributes[13]));
    }
}
