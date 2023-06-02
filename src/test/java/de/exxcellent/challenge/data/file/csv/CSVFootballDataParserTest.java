package de.exxcellent.challenge.data.file.csv;

import de.exxcellent.challenge.data.DataCollector;
import de.exxcellent.challenge.exceptions.DataInaccessibleException;
import de.exxcellent.challenge.models.FootballData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVFootballDataParserTest {
    @Test
    void shouldBeListOfFootballDataWhenParsingFootballCSV() throws DataInaccessibleException {
        List<FootballData> footballDataList = new ArrayList<>();
        footballDataList.add(new FootballData("Arsenal",38,26,9,3,79,36,87));
        footballDataList.add(new FootballData("Liverpool",38,24,8,6,67,30,80));
        footballDataList.add(new FootballData("Manchester United",38,24,5,9,87,45,77));
        footballDataList.add(new FootballData("Newcastle",38,21,8,9,74,52,71));
        footballDataList.add(new FootballData("Leeds",38,18,12,8,53,37,66));

        DataCollector<FootballData> dataCollector = new CSVFootballDataParser("test/football.csv");

        assertEquals(footballDataList.toString(), dataCollector.getData().toString());
    }

    @Test
    void shouldBeDataInaccessibleExceptionWhenParsingMalformedCSV() {
        DataCollector<FootballData> dataCollector = new CSVFootballDataParser("test/football_malformed.csv");

        assertThrows(DataInaccessibleException.class,
                dataCollector::getData);
    }

    @Test
    void shouldBeDataInaccessibleExceptionWhenNoMatchingCSVFile() {
        DataCollector<FootballData> dataCollector = new CSVFootballDataParser("test/fussball.csv");

        assertThrows(DataInaccessibleException.class,
                dataCollector::getData);
    }
}