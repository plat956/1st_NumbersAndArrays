package validator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberSequenceValidatorTest {
    private NumberSequenceValidator numberSequenceValidator;

    @BeforeClass
    void setUp() {
        numberSequenceValidator = new NumberSequenceValidator();
    }

    @Test
    void testValidateTrue() {
        boolean actual = numberSequenceValidator.validate("4334 34 -10");
        assertTrue(actual);
    }

    @Test
    void testValidateFalse() {
        boolean actual = numberSequenceValidator.validate("4334d 34 -10");
        assertFalse(actual);
    }
}