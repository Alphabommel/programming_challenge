package de.exxcellent.challenge.services;

import de.exxcellent.challenge.models.WeatherData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDataServiceTest {
    @Test
    void dayWithSmallestTemperatureSpreadShouldBeTwo() {
        List<WeatherData> weatherData = new ArrayList<>();
        weatherData.add(new WeatherData(1, 88, 59, 74, 53.8, 0, 280, 9.6, 270, 17, 1.6, 93, 23, 1004.5));
        weatherData.add(new WeatherData(2, 79, 63, 71, 46.5, 0, 330, 8.7, 340, 23, 3.3, 70, 28, 1004.5));
        weatherData.add(new WeatherData(3, 77, 55, 66, 39.6, 0, 350, 5, 350, 9, 2.8, 59, 24, 1016.8));

        WeatherDataService weatherDataService = new WeatherDataService();
        assertEquals(2, weatherDataService.getDayWithSmallestTemperatureSpread(weatherData).orElse(0));
    }
}