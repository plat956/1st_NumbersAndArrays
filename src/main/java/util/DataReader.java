package util;

import entity.DecimalNumber;
import exception.DecimalNumberCastingException;
import exception.InputFileReadingException;
import factory.DecimalNumberFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DataReader {
    private static final Logger logger = LogManager.getLogger();
    private static final String DECIMAL_DELIMITER = "\\s+";

    public String[] read(String filePath) throws InputFileReadingException {
        logger.info("Reading the \"{}\" file", filePath);
        File file = new File(filePath);

        String[] result = {};
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineChunks = line.split(DECIMAL_DELIMITER);
                result = Stream.concat(Arrays.stream(result), Arrays.stream(lineChunks)).toArray(String[]::new);
            }
        } catch (IOException ex) {
            throw new InputFileReadingException("That's impossible to read from file: " + filePath, ex);
        }

        return result;
    }
}
