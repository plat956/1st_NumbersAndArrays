package by.latushko.training.parser.impl;

import by.latushko.training.entity.DecimalNumber;
import by.latushko.training.entity.IntArray;
import by.latushko.training.exception.DecimalNumberParseException;
import by.latushko.training.exception.IntArrayParseException;
import by.latushko.training.factory.DecimalNumberFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import by.latushko.training.parser.CustomParser;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class CustomParserImplTest {
    private CustomParser customParser;

    @BeforeClass
    public void setUp() {
        customParser = new CustomParserImpl();
    }

    @Test
    public void testParseDecimalNumber() {
        DecimalNumber expected = DecimalNumberFactory.produceNumber(-200.95);
        DecimalNumber actual = null;
        try {
            actual = customParser.parseDecimalNumber("-200.95");
        } catch (DecimalNumberParseException ex) {
            fail("Something went wrong during casting your number", ex);
        }

        assertEquals(expected, actual);
    }

    @Test(expectedExceptions = DecimalNumberParseException.class)
    public void testParseDecimalNumberException() throws DecimalNumberParseException {
        customParser.parseDecimalNumber("d3b.95");
    }

    @Test
    public void testParseIntArray() {
        IntArray expected = new IntArray(5, -9, 0, 12);
        IntArray actual = null;
        try {
            actual = customParser.parseIntArray("5 -9 0 12");
        } catch (IntArrayParseException ex) {
            fail("Something went wrong during casting your sequence", ex);
        }

        assertEquals(expected, actual);
    }
}