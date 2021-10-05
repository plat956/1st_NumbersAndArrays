package util;

import exception.InputFileReadingException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class DataReaderTest {
    private static final String DECIMAL_DELIMITER = "\\s+";
    private static final String NUMBERS_FILE_PATH = "src\\test\\resources\\data\\numbers.txt";
    private static final String ARRAY_FILE_PATH = "src\\test\\resources\\data\\array.txt";
    private DataReader dataReader;

    @BeforeClass
    void setUp() {
        dataReader = new DataReader();
    }

    @Test
    void testReadExtractionsByDelimiter() {
        List<String> expected = Arrays.asList("-10.2", "5", "5.2", "7.0");

        List<String> actual = null;
        try {
            actual = dataReader.readExtractionsByDelimiter(NUMBERS_FILE_PATH, DECIMAL_DELIMITER);
        } catch (InputFileReadingException e) {
            fail("Something went wrong during reading from file", e);
        }

        assertEquals(expected, actual);
    }

    @Test
    void testReadLines() {
        List<String> expected = Arrays.asList("_$sds 05 55", "6 10 -1 15 6", "5. 5 4 3 0");

        List<String> actual = null;
        try {
            actual = dataReader.readLines(ARRAY_FILE_PATH);
        } catch (InputFileReadingException e) {
            fail("Something went wrong during reading from file", e);
        }

        assertEquals(expected, actual);
    }
}