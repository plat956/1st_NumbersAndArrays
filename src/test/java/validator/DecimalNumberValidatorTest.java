package validator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import validator.DecimalNumberValidator;

import static org.testng.Assert.*;

public class DecimalNumberValidatorTest {
    private DecimalNumberValidator decimalNumberValidator;

    @BeforeClass
    void setUp() {
        decimalNumberValidator = new DecimalNumberValidator();
    }

    @Test
    void testValidateTrue() {
        boolean actual = decimalNumberValidator.validate("5.78");
        assertTrue(actual);
    }

    @Test
    void testValidateFalse() {
        boolean actual = decimalNumberValidator.validate("dd43c.78");
        assertFalse(actual);
    }
}