package by.latushko.training.service.impl;

import by.latushko.training.entity.IntArray;
import by.latushko.training.exception.IntArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.latushko.training.service.IntArraySortingService;

public class IntArraySortingServiceImpl implements IntArraySortingService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void bubbleSort(IntArray array) {
        logger.info("Start bubble sorting of the array: {}", array.toString());
        try {
            for (int i = 0; i < array.length() - 1; i++) {
                for (int j = 0; j < array.length() - i - 1; j++) {
                    if (array.getElement(j) > array.getElement(j + 1)) {
                        swap(array, j, j + 1);
                    }
                }
            }
            logger.info("Sorted array by bubble algorithm is: {}", array.toString());
        } catch (IntArrayException ex) {
            logger.error("Impossible to sort the array {} because of elements access failed", array.toString(), ex);
        }
    }

    @Override
    public void selectionSort(IntArray array) {
        logger.info("Start selection sorting of the array: {}", array.toString());
        try {
            for (int left = 0; left < array.length(); left++) {
                int minInd = left;
                for (int i = left; i < array.length(); i++) {
                    if (array.getElement(i) < array.getElement(minInd)) {
                        minInd = i;
                    }
                }
                swap(array, left, minInd);
            }
            logger.info("Sorted array by selection algorithm is: {}", array.toString());
        } catch (IntArrayException ex) {
            logger.error("Impossible to sort the array {} because of elements access failed", array.toString(), ex);
        }
    }

    @Override
    public void insertionSort(IntArray array) {
        logger.info("Start insertion sorting of the array: {}", array.toString());
        int n = array.length();
        try {
            for (int j = 1; j < n; j++) {
                int key = array.getElement(j);
                int i = j - 1;
                while ((i > -1) && (array.getElement(i) > key)) {
                    array.setElement(i + 1, array.getElement(i));
                    i--;
                }
                array.setElement(i + 1, key);
            }
            logger.info("Sorted array by insertion algorithm is: {}", array.toString());
        } catch (IntArrayException ex) {
            logger.error("Impossible to sort the array {} because of elements access failed", array.toString(), ex);
        }
    }

    private void swap(IntArray array, int index1, int index2) throws IntArrayException {
        int temp = array.getElement(index1);
        array.setElement(index1, array.getElement(index2));
        array.setElement(index2, temp);
    }
}
