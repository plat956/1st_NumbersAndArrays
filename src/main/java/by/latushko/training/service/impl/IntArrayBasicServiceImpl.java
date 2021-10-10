package by.latushko.training.service.impl;

import by.latushko.training.entity.DecimalNumber;
import by.latushko.training.entity.IntArray;
import by.latushko.training.exception.IntArrayInternalException;
import by.latushko.training.factory.DecimalNumberFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.latushko.training.service.ArithmeticsService;
import by.latushko.training.service.IntArrayBasicService;

public class IntArrayBasicServiceImpl implements IntArrayBasicService {
    private static final Logger logger = LogManager.getLogger();

    public int findMin(IntArray array) {
        try {
            int min = array.getElement(0);
            for (int i = 1; i < array.length(); i++) {
                int currentElem = array.getElement(i);
                if (currentElem < min) {
                    min = currentElem;
                }
            }
            logger.info("The smallest element of the array {} is {}", array.toString(), min);
            return min;
        } catch (IntArrayInternalException ex) {
            //todo
            return 0;
        }
    }

    public int findMax(IntArray array) {
        try {
            int max = array.getElement(0);
            for (int i = 1; i < array.length(); i++) {
                int currentElem = array.getElement(i);
                if (currentElem > max) {
                    max = currentElem;
                }
            }
            logger.info("The biggest element of the array {} is {}", array.toString(), max);
            return max;
        } catch (IntArrayInternalException ex) {
            //todo
            return 0;
        }
    }

    public int calculateSum(IntArray array) {
        int total = 0;
        try {
            for (int i = 0; i < array.length(); i++) {
                total += array.getElement(i);
            }
        } catch (IntArrayInternalException ex) {
            //todo
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

    public int countNegativeValues(IntArray array) {
        int counter = 0;
        try {
            for (int i = 0; i < array.length(); i++) {
                int currentElem = array.getElement(i);
                if (currentElem < 0) {
                    counter++;
                }
            }
        } catch (IntArrayInternalException ex) {
            //todo
        }
        logger.info("The the array {} contains {} negative elements", array.toString(), counter);
        return counter;
    }

    public int countPositiveValues(IntArray array) {
        int counter = 0;
        try {
            for (int i = 0; i < array.length(); i++) {
                int currentElem = array.getElement(i);
                if (currentElem > 0) {
                    counter++;
                }
            }
        } catch (IntArrayInternalException ex) {
            //todo
        }
        logger.info("The the array {} contains {} positive elements", array.toString(), counter);
        return counter;
    }

    public IntArray replaceNegativeElementsTo(IntArray array, int number) {
        try {
            for (int i = 0; i < array.length(); i++) {
                int currentElem = array.getElement(i);
                if (currentElem < 0) {
                    array.setElement(i, number);
                }
            }
        } catch (IntArrayInternalException ex) {
            //todo
        }
        logger.info("All the negative elements of the array {} has been replaced by {}", array.toString(), number);
        return array;
    }

    public IntArray replaceHigherThan100ElementsTo(IntArray array, int number) {
        try {
            for (int i = 0; i < array.length(); i++) {
                int currentElem = array.getElement(i);
                if (currentElem > 100) {
                    array.setElement(i, number);
                }
            }
        } catch (IntArrayInternalException ex) {
            //todo
        }
        logger.info("Each element is higher than 100 of the array {} has been replaced by {}", array.toString(), number);
        return array;
    }

}
