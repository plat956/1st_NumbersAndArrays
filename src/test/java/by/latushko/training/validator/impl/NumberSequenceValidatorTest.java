package by.latushko.training.validator.impl;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import by.latushko.training.validator.CustomValidator;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class NumberSequenceValidatorTest {
    private CustomValidator numberSequenceValidator;

    @BeforeClass
    public void setUp() {
        numberSequenceValidator = new NumberSequenceValidator();
    }

    @Test
    public void testValidateTrue() {
        boolean actual = numberSequenceValidator.validate("4334 34 -10");
        assertTrue(actual);
    }

    @Test
    public void testValidateFalse() {
        boolean actual = numberSequenceValidator.validate("4334d 34 -10");
        assertFalse(actual);
    }
}