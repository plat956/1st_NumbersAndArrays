package util;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DecimalNumberValidatorTest {

    @Test
    void testValidate() {
        DecimalNumberValidator decimalNumberValidator = new DecimalNumberValidator();
        boolean actual = decimalNumberValidator.validate("dd43c.  78");

        assertFalse(actual);
    }
}