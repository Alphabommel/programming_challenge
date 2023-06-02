package de.exxcellent.challenge.data.csv;

import de.exxcellent.challenge.data.DataCollector;
import de.exxcellent.challenge.data.file.csv.CSVWeatherDataParser;
import de.exxcellent.challenge.exceptions.DataInaccessibleException;
import de.exxcellent.challenge.models.WeatherData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVWeatherDataParserTest {

    @Test
    void shouldBeListOfWeatherDataWhenParsingWeatherCSV() throws DataInaccessibleException {
        List<WeatherData> weatherDataList = new ArrayList<>();
        weatherDataList.add(new WeatherData(1,88,59,74,53.8,0,280,9.6,270,17,1.6,93,23,1004.5));
        weatherDataList.add(new WeatherData(2,79,63,71,46.5,0,330,8.7,340,23,3.3,70,28,1004.5));
        weatherDataList.add(new WeatherData(3,77,55,66,39.6,0,350,5,350,9,2.8,59,24,1016.8));
        weatherDataList.add(new WeatherData(4,77,59,68,51.1,0,110,9.1,130,12,8.6,62,40,1021.1));
        weatherDataList.add(new WeatherData(5,90,66,78,68.3,0,220,8.3,260,12,6.9,84,55,1014.4));

        DataCollector<WeatherData> dataCollector = new CSVWeatherDataParser("test/weather.csv");
        assertEquals(weatherDataList.toString(), dataCollector.getData().toString());
    }

    @Test
    void shouldBeDataInaccessibleExceptionWhenParsingMalformedCSV() {
        DataCollector<WeatherData> dataCollector = new CSVWeatherDataParser("test/weather_malformed.csv");

        assertThrows(DataInaccessibleException.class,
                dataCollector::getData);
    }

    @Test
    void shouldBeDataInaccessibleExceptionWhenNoMatchingCSVFile() {
        DataCollector<WeatherData> dataCollector = new CSVWeatherDataParser("test/wetter.csv");

        assertThrows(DataInaccessibleException.class,
                dataCollector::getData);
    }
}
