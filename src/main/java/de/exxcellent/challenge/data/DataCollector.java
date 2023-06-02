package de.exxcellent.challenge.data;

import de.exxcellent.challenge.exceptions.DataInaccessibleException;

import java.util.List;

public interface DataCollector<T> {
    List<T> getData() throws DataInaccessibleException;
}
