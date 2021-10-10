package by.latushko.training.parser;

import by.latushko.training.entity.DecimalNumber;
import by.latushko.training.entity.IntArray;
import by.latushko.training.exception.DecimalNumberParseException;
import by.latushko.training.exception.IntArrayParseException;

public interface CustomParser {
    DecimalNumber parseDecimalNumber(String unCasted) throws DecimalNumberParseException;

    IntArray parseIntArray(String unCasted) throws IntArrayParseException;
}
