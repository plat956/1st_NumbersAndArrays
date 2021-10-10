package by.latushko.training.reader;

import by.latushko.training.exception.InputFileReadingException;

import java.util.List;

public interface DataReader {
    List<String> readExtractionsSeparatedBySpace(String filePath) throws InputFileReadingException;

    List<String> readLines(String filePath) throws InputFileReadingException;
}
