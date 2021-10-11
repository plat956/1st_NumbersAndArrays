package by.latushko.training.service.impl;

import by.latushko.training.entity.DecimalNumber;
import by.latushko.training.entity.IntArray;
import by.latushko.training.factory.DecimalNumberFactory;
import by.latushko.training.service.IntArrayStreamService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class IntArrayStreamServiceImplTest {
    private IntArrayStreamService intArraystreamService;

    @BeforeClass
    public void setUp() {
        intArraystreamService = new IntArrayStreamServiceImpl();
    }

    @Test
    public void testFindMin() {
        IntArray array = new IntArray(2, 3, 5, -100, 0, 1, -9);
        int expected = -100;
        int actual = intArraystreamService.findMin(array).getAsInt();

        assertEquals(expected, actual);
    }

    @Test
    public void testFindMinWrong() {
        IntArray array = new IntArray(5, 53, 11, 4, -9);
        int expected = 56;
        int actual = intArraystreamService.findMin(array).getAsInt();

        assertNotEquals(expected, actual);
    }

    @Test
    public void testFindMax() {
        IntArray array = new IntArray(12, 44, 76, -1, 38, 31, -92);
        int expected = 76;
        int actual = intArraystreamService.findMax(array).getAsInt();

        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateSum() {
        IntArray array = new IntArray(5, 11, 79, -89, 0, -71, 0);
        int expected = -65;
        int actual = intArraystreamService.calculateSum(array);

        assertEquals(expected, actual);
    }

    @Test
    public void testCalculateAverage() {
        IntArray array = new IntArray(24, 40, 22, -2, 8, -4, 10);
        DecimalNumber expected = DecimalNumberFactory.produceNumber(14.0);
        DecimalNumber actual = intArraystreamService.calculateAverage(array).get();

        assertEquals(expected, actual);
    }

    @Test
    public void testCountNegativeValues() {
        IntArray array = new IntArray(11, -1, 9, -3);
        long expected = 2L;
        long actual = intArraystreamService.countNegativeValues(array);

        assertEquals(expected, actual);
    }

    @Test
    public void testCountPositiveValues() {
        IntArray array = new IntArray(5, -1, 5, -3, 10);
        long expected = 3L;
        long actual = intArraystreamService.countPositiveValues(array);

        assertEquals(expected, actual);
    }

    @Test
    public void testReplaceNegativeElementsTo() {
        IntArray expected = new IntArray(0, 0, 55, 0, 21);
        IntArray tempArray = new IntArray(-35, -21, 55, -67, 21);
        IntArray actual = intArraystreamService.replaceNegativeElementsTo(tempArray, 0);

        assertEquals(expected, actual);
    }

    @Test
    public void testReplaceHigher100ElementsTo() {
        IntArray expected = new IntArray(-235, -121, 100, 100, 5, 10, 0, -3);
        IntArray tempArray = new IntArray(-235, -121, 155, 267, 5, 10, 0, -3);
        IntArray actual = intArraystreamService.replaceHigherThan100ElementsTo(tempArray, 100);

        assertEquals(expected, actual);
    }
}