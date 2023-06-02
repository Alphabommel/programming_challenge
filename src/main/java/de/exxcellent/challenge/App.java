package de.exxcellent.challenge;

import de.exxcellent.challenge.data.DataCollector;
import de.exxcellent.challenge.data.csv.WeatherDataParser;
import de.exxcellent.challenge.exceptions.DataInaccessibleException;
import de.exxcellent.challenge.models.WeatherData;
import de.exxcellent.challenge.services.WeatherDataService;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        try {
            switch (args[0]) {
                case "--weather":
                    DataCollector<WeatherData> weatherDataDataCollector = new WeatherDataParser(args[1]);

                    List<WeatherData> weatherData = weatherDataDataCollector.getData();
                    Integer dayWithSmallestTempSpread = new WeatherDataService().getDayWithSmallestTemperatureSpread(weatherData)
                            .orElseThrow();
                    System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
                    break;

                case "--football":
                    break;
            }
        } catch (DataInaccessibleException | NoSuchElementException e) {
            System.out.println("Failed to load data.");
        }
    }
}
