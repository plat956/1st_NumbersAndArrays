package by.latushko.training.service.impl;

import by.latushko.training.entity.DecimalNumber;
import by.latushko.training.entity.IntArray;
import by.latushko.training.exception.IntArrayException;
import by.latushko.training.factory.DecimalNumberFactory;
import by.latushko.training.service.ArithmeticsService;
import by.latushko.training.service.IntArrayBasicService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.OptionalInt;

public class IntArrayBasicServiceImpl implements IntArrayBasicService {
    private static final Logger logger = LogManager.getLogger();

    public OptionalInt findMin(IntArray array) {
        try {
            int min = array.getElement(0);
            for (int i = 1; i < array.length(); i++) {
                int currentElem = array.getElement(i);
                if (currentElem < min) {
                    min = currentElem;
                }
            }
            logger.info("The smallest element of the array {} is {}", array.toString(), min);
            return OptionalInt.of(min);
        } catch (IntArrayException ex) {
            logger.error("Impossible to determine the smallest element of the array {} because of elements access failed", array.toString(), ex);
            return OptionalInt.empty();
        }
    }

    public OptionalInt findMax(IntArray array) {
        try {
            int max = array.getElement(0);
            for (int i = 1; i < array.length(); i++) {
                int currentElem = array.getElement(i);
                if (currentElem > max) {
                    max = currentElem;
                }
            }
            logger.info("The biggest element of the array {} is {}", array.toString(), max);
            return OptionalInt.of(max);
        } catch (IntArrayException ex) {
            logger.error("Impossible to determine the biggest element of the array {} because of elements access failed", array.toString(), ex);
            return OptionalInt.empty();
        }
    }

    public int calculateSum(IntArray array) {
        int total = 0;
        try {
            for (int i = 0; i < array.length(); i++) {
                total += array.getElement(i);
            }
        } catch (IntArrayException ex) {
            total = 0;
        }
        logger.info("Total amount of the array elements {} is {}", array.toString(), total);
        return total;
    }

    public DecimalNumber calculateAverage(IntArray array) {
        ArithmeticsService arithmeticsService = new ArithmeticsServiceImpl();
        DecimalNumber amount = DecimalNumberFactory.produceNumber(calculateSum(array));
        DecimalNumber length = DecimalNumberFactory.produceNumber(array.length());
        DecimalNumber average = arithmeticsService.divide(amount, length);
        logger.info("The average element of the array {} is {}", array.toString(), average);
        return average;
    }

    public long countNegativeValues(IntArray array) {
        long counter = 0L;
        try {
            for (int i = 0; i < array.length(); i++) {
                int currentElem = array.getElement(i);
                if (currentElem < 0) {
                    counter++;
                }
            }
        } catch (IntArrayException ex) {
            counter = 0L;
        }
        logger.info("The the array {} contains {} negative elements", array.toString(), counter);
        return counter;
    }

    public long countPositiveValues(IntArray array) {
        long counter = 0L;
        try {
            for (int i = 0; i < array.length(); i++) {
                int currentElem = array.getElement(i);
                if (currentElem > 0) {
                    counter++;
                }
            }
        } catch (IntArrayException ex) {
            counter = 0L;
        }
        logger.info("The the array {} contains {} positive elements", array.toString(), counter);
        return counter;
    }

    public Optional<IntArray> replaceNegativeElementsTo(IntArray array, int number) {
        IntArray copiedArray = new IntArray(array.getInternalArray());
        try {
            for (int i = 0; i < copiedArray.length(); i++) {
                int currentElem = copiedArray.getElement(i);
                if (currentElem < 0) {
                    copiedArray.setElement(i, number);
                }
            }
            logger.info("All the negative elements of the array {} has been replaced by {}", copiedArray.toString(), number);
            return Optional.of(copiedArray);
        } catch (IntArrayException ex) {
            logger.error("Impossible to do replacement in the array {} because of elements access failed", array.toString(), ex);
            return Optional.empty();
        }
    }

    public Optional<IntArray> replaceHigherThan100ElementsTo(IntArray array, int number) {
        IntArray copiedArray = new IntArray(array.getInternalArray());
        try {
            for (int i = 0; i < copiedArray.length(); i++) {
                int currentElem = copiedArray.getElement(i);
                if (currentElem > 100) {
                    copiedArray.setElement(i, number);
                }
            }
            logger.info("Each element is higher than 100 of the array {} has been replaced by {}", copiedArray.toString(), number);
            return Optional.of(copiedArray);
        } catch (IntArrayException ex) {
            logger.error("Impossible to do replacement in the array {} because of elements access failed", array.toString(), ex);
            return Optional.empty();
        }
    }

}
