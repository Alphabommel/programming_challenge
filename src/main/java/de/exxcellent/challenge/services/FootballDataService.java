package de.exxcellent.challenge.services;

import de.exxcellent.challenge.models.FootballData;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FootballDataService {
    public Optional<String> getTeamWithSmallestGoalSpread(List<FootballData> footballData) {
        // chooses first option if there are several available
        return footballData.stream()
                .min(Comparator.comparingInt(FootballData::getGoalSpread))
                .map(FootballData::getTeam);
    }
}
