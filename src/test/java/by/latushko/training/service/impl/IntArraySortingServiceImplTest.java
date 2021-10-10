package by.latushko.training.service.impl;

import by.latushko.training.entity.IntArray;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import by.latushko.training.service.IntArraySortingService;

import static org.testng.Assert.*;

public class IntArraySortingServiceImplTest {
    IntArraySortingService intArraySortingService;
    IntArray actual;
    IntArray expected;

    @BeforeClass
    void setUpClass(){
        intArraySortingService = new IntArraySortingServiceImpl();
    }

    @BeforeMethod
    void setUpMethod() {
        actual = new IntArray(10, 20, 5, -3, 0, 99, 1, 11, 4, 7, 64);
        expected = new IntArray(-3, 0, 1, 4, 5, 7, 10, 11, 20, 64, 99);
    }

    @Test
    public void testBubbleSort() {
        intArraySortingService.bubbleSort(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testSelectionSort() {
        intArraySortingService.selectionSort(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testInsertionSort() {
        intArraySortingService.insertionSort(actual);
        assertEquals(expected, actual);
    }
}