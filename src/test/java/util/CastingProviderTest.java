package util;

import entity.DecimalNumber;
import exception.DecimalNumberCastingException;
import factory.DecimalNumberFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CastingProviderTest {

    @Test
    void testCast() {
        DecimalNumber expected = DecimalNumberFactory.produceNumber(-200.95);

        CastingProvider castingProvider = new CastingProvider();
        DecimalNumber actual = null;
        try {
            actual = castingProvider.cast("-200.95");
        } catch (DecimalNumberCastingException e) {
            fail("Something went wrong during casting your number", e);
        }

        assertEquals(expected, actual);
    }

}