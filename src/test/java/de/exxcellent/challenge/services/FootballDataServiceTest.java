package de.exxcellent.challenge.services;

import de.exxcellent.challenge.models.FootballData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FootballDataServiceTest {

    @Test
    void teamWithSmallestGoalSpreadShouldBeLiverpool() {
        List<FootballData> footballData = new ArrayList<>();
        footballData.add(new FootballData("Arsenal", 38, 26, 9, 3, 79, 36, 87));
        footballData.add(new FootballData("Liverpool", 38, 24, 8, 6, 67, 30, 80));
        footballData.add(new FootballData("Manchester United", 38, 24, 5, 9, 87, 45, 77));

        FootballDataService footballDataService = new FootballDataService();
        assertEquals("Liverpool", footballDataService.getTeamWithSmallestGoalSpread(footballData).orElse("Manchester City"));
    }
}
