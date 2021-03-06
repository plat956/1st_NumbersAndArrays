package by.latushko.training.validator.impl;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import by.latushko.training.validator.CustomValidator;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DecimalNumberValidatorTest {
    private CustomValidator decimalNumberValidator;

    @BeforeClass
    public void setUp() {
        decimalNumberValidator = new DecimalNumberValidator();
    }

    @Test
    public void testValidateTrue() {
        boolean actual = decimalNumberValidator.validate("5.78");
        assertTrue(actual);
    }

    @Test
    public void testValidateFalse() {
        boolean actual = decimalNumberValidator.validate("dd43c.78");
        assertFalse(actual);
    }
}