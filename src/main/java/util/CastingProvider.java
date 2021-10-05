package util;


import entity.DecimalNumber;
import entity.IntArray;
import exception.DecimalNumberCastingException;
import exception.IntArrayCastingException;
import factory.DecimalNumberFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import validator.DecimalNumberValidator;
import validator.NumberSequenceValidator;

public class CastingProvider {
    private static final Logger logger = LogManager.getLogger();
    private static final String DECIMAL_DELIMITER = "\\s+";

    public DecimalNumber castToDecimalNumber(String unCasted) throws DecimalNumberCastingException{
        DecimalNumberValidator decimalNumberValidator = new DecimalNumberValidator();
        if(!decimalNumberValidator.validate(unCasted)) {
            logger.error("Line \"{}\" contains invalid characters for DecimalNumber casting", unCasted);
            throw new DecimalNumberCastingException("That's impossible to cast " + unCasted + " to DecimalNumber class");
        }
        double tempNumber = Double.valueOf(unCasted);
        return DecimalNumberFactory.produceNumber(tempNumber);
    }

    public IntArray castToIntArray(String unCasted) throws IntArrayCastingException {
        NumberSequenceValidator numberSequenceValidator = new NumberSequenceValidator();
        if(!numberSequenceValidator.validate(unCasted)) {
            logger.error("Line \"{}\" contains invalid characters", unCasted);
            throw new IntArrayCastingException("That's impossible to cast " + unCasted + " to IntArray class");
        }
        String[] lineChunks = unCasted.split(DECIMAL_DELIMITER);
        IntArray array = new IntArray(lineChunks.length);
        for (int i = 0; i < lineChunks.length; i++) {
            array.setElement(i, Integer.parseInt(lineChunks[i]));
        }
        return array;
    }
}
