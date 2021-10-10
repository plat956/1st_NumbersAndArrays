package by.latushko.training.reader.impl;

import by.latushko.training.exception.InputFileReadException;
import by.latushko.training.reader.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataReaderImpl implements DataReader {
    private static final Logger logger = LogManager.getLogger();
    private static final String SPACE_DELIMITER = "\\s+";

    public List<String> readExtractionsSeparatedBySpace(String filePath) throws InputFileReadException {
        return read(filePath, SPACE_DELIMITER);
    }

    public List<String> readLines(String filePath) throws InputFileReadException {
        return read(filePath, null);
    }

    private List<String> read(String filePath, String delimiter) throws InputFileReadException {
        logger.info("Reading the \"{}\" file", filePath);

        ClassLoader loader = getClass().getClassLoader();
        URL resource = loader.getResource(filePath);
        File file = new File(resource.getFile());

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
            throw new InputFileReadException("That's impossible to read from file: " + filePath, ex);
        }

        return result;
    }
}
