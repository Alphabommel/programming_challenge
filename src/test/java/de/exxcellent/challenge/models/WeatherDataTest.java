package de.exxcellent.challenge.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDataTest {

    @Test
    void calculateTemperatureSpread() {
        WeatherData weatherData = new WeatherData(1, 88, 59, 74, 53.8, 0, 280, 9.6, 270, 17, 1.6, 93, 23, 1004.5);

        assertEquals(29, weatherData.getTemperatureSpread());
    }
}
