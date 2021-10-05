package service.impl;

import entity.IntArray;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import service.IntArraySortingService;

import static org.testng.Assert.*;

public class IntArraySortingServiceImplTest {

    IntArraySortingService intArraySortingService;
    IntArray inputArray;
    IntArray expected;

    @BeforeMethod
    public void setUp() {
        intArraySortingService = new IntArraySortingServiceImpl();
        inputArray = new IntArray(10, 20, 5, -3, 0, 99, 1, 11, 4, 7, 64);
        expected = new IntArray(-3, 0, 1, 4, 5, 7, 10, 11, 20, 64, 99);
    }

    @Test
    public void testBubbleSort() {
        IntArray actual = intArraySortingService.bubbleSort(inputArray);
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectionSort() {
        IntArray actual = intArraySortingService.selectionSort(inputArray);
        assertEquals(expected, actual);
    }

    @Test
    public void testInsertionSort() {
        IntArray actual = intArraySortingService.insertionSort(inputArray);
        assertEquals(expected, actual);
    }
}