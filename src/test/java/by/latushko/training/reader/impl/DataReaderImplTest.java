package by.latushko.training.reader.impl;

import by.latushko.training.exception.InputFileReadException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import by.latushko.training.reader.DataReader;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class DataReaderImplTest {
    private static final String NUMBERS_FILE_PATH = "data/numbers.txt";
    private static final String ARRAY_FILE_PATH = "data/array.txt";
    private static final String ARRAY_WRONG_FILE_PATH = "dataa/arrays.txt";
    private DataReader dataReader;

    @BeforeClass
    public void setUp() {
        dataReader = new DataReaderImpl();
    }

    @Test
    public void testReadExtractionsByDelimiter() {
        List<String> expected = Arrays.asList("-10.2", "5", "5.2", "7.0");
        List<String> actual = null;
        try {
            actual = dataReader.readExtractionsSeparatedBySpace(NUMBERS_FILE_PATH);
        } catch (InputFileReadException ex) {
            fail("Something went wrong during reading from file", ex);
        }

        assertEquals(expected, actual);
    }

    @Test
    public void testReadLines() {
        List<String> expected = Arrays.asList("_$sds 05 55", "6 10 -1 15 6", "5. 5 4 3 0");
        List<String> actual = null;
        try {
            actual = dataReader.readLines(ARRAY_FILE_PATH);
        } catch (InputFileReadException ex) {
            fail("Something went wrong during reading from file", ex);
        }

        assertEquals(expected, actual);
    }

    @Test
    public void testReadLinesException() {
        assertThrows(InputFileReadException.class, ()-> dataReader.readLines(ARRAY_WRONG_FILE_PATH));
    }
}