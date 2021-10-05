package service.impl;

import entity.DecimalNumber;
import entity.IntArray;
import factory.DecimalNumberFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service.IntArrayBasicHandlingService;

import static org.testng.Assert.*;

public class IntArrayBasicHandlingServiceImplTest {
    IntArrayBasicHandlingService intArrayBasicHandlingService;

    @BeforeClass
    void setUp() {
        intArrayBasicHandlingService = new IntArrayBasicHandlingServiceImpl();
    }

    @Test
    void testGetMin() {
        IntArray array = new IntArray(2, 3, 5, -100, 0, 1, -9);
        int expected = -100;
        int actual = intArrayBasicHandlingService.getMin(array);

        assertEquals(expected, actual);
    }

    @Test
    void testGetMax() {
        IntArray array = new IntArray(12, 44, 76, -1, 38, 31, -92);
        int expected = 76;
        int actual = intArrayBasicHandlingService.getMax(array);

        assertEquals(expected, actual);
    }

    @Test
    void testGetSum() {
        IntArray array = new IntArray(5, 11, 79, -89, 0, -71, 0);
        int expected = -65;
        int actual = intArrayBasicHandlingService.getSum(array);

        assertEquals(expected, actual);
    }

    @Test
    void testGetAverage() {
        IntArray array = new IntArray(24, 41, 22, -1, 9, -3, 10);
        DecimalNumber expected = DecimalNumberFactory.produceNumber(14.57);
        DecimalNumber actual = intArrayBasicHandlingService.getAverage(array);

        assertEquals(expected, actual);
    }

    @Test
    void testGetNegativeCount() {
        IntArray array = new IntArray(11, -1, 9, -3);
        int expected = 2;
        int actual = intArrayBasicHandlingService.getNegativeCount(array);

        assertEquals(expected, actual);
    }

    @Test
    void testGetPositiveCount() {
        IntArray array = new IntArray(5, -1, 5, -3, 10);
        int expected = 3;
        int actual = intArrayBasicHandlingService.getPositiveCount(array);

        assertEquals(expected, actual);
    }

    @Test
    void testReplaceNegativeElementsTo() {
        IntArray expected = new IntArray(0, 0, 55, 0, 21);
        IntArray tempArray = new IntArray(-35, -21, 55, -67, 21);
        IntArray actual = intArrayBasicHandlingService.replaceNegativeElementsTo(tempArray, 0);

        assertEquals(expected, actual);
    }

    @Test
    void testReplaceHigher100ElementsTo() {
        IntArray expected = new IntArray(-235, -121, 100, 100, 5, 10, 0, -3);
        IntArray tempArray = new IntArray(-235, -121, 155, 267, 5, 10, 0, -3);
        IntArray actual = intArrayBasicHandlingService.replaceHigher100ElementsTo(tempArray, 100);

        assertEquals(expected, actual);
    }
}