package de.exxcellent.challenge.services;

import de.exxcellent.challenge.models.WeatherData;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class WeatherDataService {
    public Optional<Integer> getDayWithSmallestTemperatureSpread(List<WeatherData> weatherData) {
        // chooses first option if there are several available
        return weatherData.stream()
                .min(Comparator.comparingInt(WeatherData::getTemperatureSpread))
                .map(WeatherData::getDay);
    }
}