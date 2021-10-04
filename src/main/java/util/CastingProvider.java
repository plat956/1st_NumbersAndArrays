package util;


import entity.DecimalNumber;
import exception.DecimalNumberCastingException;
import factory.DecimalNumberFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CastingProvider {
    private static final Logger logger = LogManager.getLogger();

    public DecimalNumber cast(String unCasted) throws DecimalNumberCastingException{
        DecimalNumberValidator decimalNumberValidator = new DecimalNumberValidator();
        if(!decimalNumberValidator.validate(unCasted)) {
            logger.error("Line \"{}\" contains invalid characters for DecimalNumber casting", unCasted);
            throw new DecimalNumberCastingException("That's impossible to cast " + unCasted + " to DecimalNumber class");
        }
        double tempNumber = Double.valueOf(unCasted);
        return DecimalNumberFactory.produceNumber(tempNumber);
    }
}
