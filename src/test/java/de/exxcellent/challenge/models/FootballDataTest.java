package de.exxcellent.challenge.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FootballDataTest {
    @Test
    void calculateGoalSpread() {
        FootballData footballData = new FootballData("Arsenal",38,26,9,3,79,36,87);

        assertEquals(43, footballData.getGoalSpread());
    }
}