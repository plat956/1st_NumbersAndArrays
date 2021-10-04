package util;

import entity.DecimalNumber;
import exception.DecimalNumberCastingException;
import exception.InputFileReadingException;
import factory.DecimalNumberFactory;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import static org.testng.Assert.*;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class DataReaderTest {
    private static final String FILE_PATH = "src\\test\\resources\\data\\input.txt";

    @Test
    void testRead() {
        String[] expected = { "-10.2", "5", "5.2", "7.0" };

        DataReader dataReader = new DataReader();

        String[] actual = null;
        try {
            actual = dataReader.read(FILE_PATH);
        } catch (InputFileReadingException e) {
            fail("Something went wrong during reading from file", e);
        }

        assertArrayEquals(expected, actual);
    }
}