package util;

import entity.DecimalNumber;
import entity.IntArray;
import exception.DecimalNumberCastingException;
import exception.IntArrayCastingException;
import factory.DecimalNumberFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CastingProviderTest {
    private CastingProvider castingProvider;

    @BeforeClass
    void setUp() {
        castingProvider = new CastingProvider();
    }

    @Test
    void testCastToDecimalNumber() {
        DecimalNumber expected = DecimalNumberFactory.produceNumber(-200.95);
        DecimalNumber actual = null;
        try {
            actual = castingProvider.castToDecimalNumber("-200.95");
        } catch (DecimalNumberCastingException e) {
            fail("Something went wrong during casting your number", e);
        }

        assertEquals(expected, actual);
    }

    @Test
    void testCastToIntArray() {
        IntArray expected = new IntArray(5, -9, 0, 12);
        IntArray actual = null;
        try {
            actual = castingProvider.castToIntArray("5 -9 0 12");
        } catch (IntArrayCastingException e) {
            fail("Something went wrong during casting your sequence", e);
        }

        assertEquals(expected, actual);
    }

}