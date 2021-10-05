package service.Impl;

import entity.IntArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.IntArraySortingService;

public class IntArraySortingServiceImpl implements IntArraySortingService {
    private static final Logger logger = LogManager.getLogger();

    private void swap(IntArray array, int index1, int index2) {
        int temp = array.getElement(index1);
        array.setElement(index1, array.getElement(index2));
        array.setElement(index2, temp);
    }

    @Override
    public IntArray bubbleSort(IntArray array) {
        logger.info("Start bubble sorting of the array: {}", array.toString());
        for (int i = 0; i < array.length() - 1; i++) {
            for (int j = 0; j < array.length() - i - 1; j++) {
                if (array.getElement(j) > array.getElement(j + 1)) {
                    swap(array, j, j + 1);
                }
            }
        }

        logger.info("Sorted array by bubble algorithm is: {}", array.toString());
        return array;
    }

    @Override
    public IntArray selectionSort(IntArray array) {
        logger.info("Start selection sorting of the array: {}", array.toString());
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
        return array;
    }

    @Override
    public IntArray insertionSort(IntArray array) {
        logger.info("Start insertion sorting of the array: {}", array.toString());
        for (int left = 0; left < array.length(); left++) {
            int value = array.getElement(left);
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array.getElement(i)) {
                    array.setElement(i + 1, array.getElement(i));
                } else {
                    break;
                }
            }
            array.setElement(i + 1, value);
        }

        logger.info("Sorted array by insertion algorithm is: {}", array.toString());
        return array;
    }
}
