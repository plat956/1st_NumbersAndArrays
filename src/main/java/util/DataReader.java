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

    public List<String> readExtractionsByDelimiter(String filePath, String delimiter) throws InputFileReadingException {
        return read(filePath, delimiter);
    }

    public List<String> readLines(String filePath) throws InputFileReadingException {
        return read(filePath, null);
    }

    private List<String> read(String filePath, String delimiter) throws InputFileReadingException {
        logger.info("Reading the \"{}\" file", filePath);
        File file = new File(filePath);

        List<String> result = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if(delimiter != null) {
                    String[] lineChunks = line.split(delimiter);
                    result.addAll(Arrays.stream(lineChunks).toList());
                } else {
                    result.add(line);
                }
            }
        } catch (IOException ex) {
            throw new InputFileReadingException("That's impossible to read from file: " + filePath, ex);
        }

        return result;
    }
}
