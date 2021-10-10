package by.latushko.training.reader.impl;

import by.latushko.training.exception.InputFileReadingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import by.latushko.training.reader.DataReader;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class DataReaderImplTest {
    private static final String NUMBERS_FILE_PATH = "data/numbers.txt";
    private static final String ARRAY_FILE_PATH = "data/array.txt";
    private DataReader dataReader;

    @BeforeClass
    void setUp() {
        dataReader = new DataReaderImpl();
    }

    @Test
    void testReadExtractionsByDelimiter() {
        List<String> expected = Arrays.asList("-10.2", "5", "5.2", "7.0");
        List<String> actual = null;
        try {
            actual = dataReader.readExtractionsSeparatedBySpace(NUMBERS_FILE_PATH);
        } catch (InputFileReadingException ex) {
            fail("Something went wrong during reading from file", ex);
        }

        assertEquals(expected, actual);
    }

    @Test
    void testReadLines() {
        List<String> expected = Arrays.asList("_$sds 05 55", "6 10 -1 15 6", "5. 5 4 3 0");
        List<String> actual = null;
        try {
            actual = dataReader.readLines(ARRAY_FILE_PATH);
        } catch (InputFileReadingException ex) {
            fail("Something went wrong during reading from file", ex);
        }

        assertEquals(expected, actual);
    }
}