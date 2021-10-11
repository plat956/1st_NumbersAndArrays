package by.latushko.training.parser.impl;


import by.latushko.training.entity.DecimalNumber;
import by.latushko.training.entity.IntArray;
import by.latushko.training.exception.DecimalNumberParseException;
import by.latushko.training.exception.IntArrayException;
import by.latushko.training.exception.IntArrayParseException;
import by.latushko.training.factory.DecimalNumberFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.latushko.training.parser.CustomParser;
import by.latushko.training.validator.impl.DecimalNumberValidator;
import by.latushko.training.validator.impl.NumberSequenceValidator;

public class CustomParserImpl implements CustomParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String SPACE_DELIMITER = "\\s+";

    @Override
    public DecimalNumber parseDecimalNumber(String unCasted) throws DecimalNumberParseException {
        DecimalNumberValidator decimalNumberValidator = new DecimalNumberValidator();
        if(!decimalNumberValidator.validate(unCasted)) {
            logger.error("Line \"{}\" contains invalid characters for DecimalNumber casting", unCasted);
            throw new DecimalNumberParseException("That's impossible to cast " + unCasted + " to DecimalNumber class");
        }
        double tempNumber = Double.parseDouble(unCasted);
        return DecimalNumberFactory.produceNumber(tempNumber);
    }

    @Override
    public IntArray parseIntArray(String unCasted) throws IntArrayParseException {
        NumberSequenceValidator numberSequenceValidator = new NumberSequenceValidator();
        if(!numberSequenceValidator.validate(unCasted)) {
            logger.error("Line \"{}\" contains invalid characters", unCasted);
            throw new IntArrayParseException("That's impossible to cast " + unCasted + " to IntArray class");
        }
        String[] lineChunks = unCasted.split(SPACE_DELIMITER);
        IntArray array = null;
        try {
            array = new IntArray(lineChunks.length);
        } catch (IntArrayException e) {
            logger.error("Can't produce an array with length: {}", lineChunks.length, e);
            throw new IntArrayParseException(e);
        }

        try {
            for (int i = 0; i < lineChunks.length; i++) {
                array.setElement(i, Integer.parseInt(lineChunks[i]));
            }
        } catch (IntArrayException e) {
            logger.error("Can't modify array elements: {}", array.toString(), e);
            throw new IntArrayParseException(e);
        }
        return array;
    }
}
