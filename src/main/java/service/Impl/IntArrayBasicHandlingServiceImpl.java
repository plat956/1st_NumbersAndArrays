package service.Impl;

import entity.DecimalNumber;
import entity.IntArray;
import factory.DecimalNumberFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.ArithmeticsService;
import service.IntArrayBasicHandlingService;

public class IntArrayBasicHandlingServiceImpl implements IntArrayBasicHandlingService {
    private static final Logger logger = LogManager.getLogger();

    public int getMin(IntArray array) {
        int min = array.getElement(0);
        for (int i = 1; i < array.length(); i++) {
            int currentElem = array.getElement(i);
            if(currentElem < min) {
                min = currentElem;
            }
        }
        logger.info("The smallest element of the array {} is {}", array.toString(), min);
        return min;
    }

    public int getMax(IntArray array) {
        int max = array.getElement(0);
        for (int i = 1; i < array.length(); i++) {
            int currentElem = array.getElement(i);
            if(currentElem > max) {
                max = currentElem;
            }
        }
        logger.info("The biggest element of the array {} is {}", array.toString(), max);
        return max;
    }

    public int getSum(IntArray array) {
        int total = 0;
        for (int i = 0; i < array.length(); i++) {
            total += array.getElement(i);
        }
        logger.info("Total amount of the array elements {} is {}", array.toString(), total);
        return total;
    }

    public DecimalNumber getAverage(IntArray array) {
        ArithmeticsService arithmeticsService = new ArithmeticsServiceImpl();
        DecimalNumber amount = DecimalNumberFactory.produceNumber(getSum(array));
        DecimalNumber length = DecimalNumberFactory.produceNumber(array.length());
        DecimalNumber average = arithmeticsService.round(arithmeticsService.divide(amount, length), 2);
        logger.info("The average element of the array {} is {}", array.toString(), average);
        return average;
    }

    public int getNegativeCount(IntArray array) {
        int counter = 0;
        for (int i = 0; i < array.length(); i++) {
            int currentElem = array.getElement(i);
            if(currentElem < 0) {
                counter++;
            }
        }
        logger.info("The the array {} contains {} negative elements", array.toString(), counter);
        return counter;
    }

    public int getPositiveCount(IntArray array) {
        int counter = 0;
        for (int i = 0; i < array.length(); i++) {
            int currentElem = array.getElement(i);
            if(currentElem > 0) {
                counter++;
            }
        }
        logger.info("The the array {} contains {} positive elements", array.toString(), counter);
        return counter;
    }

    public IntArray replaceNegativeElementsTo(IntArray array, int number) {
        for (int i = 0; i < array.length(); i++) {
            int currentElem = array.getElement(i);
            if(currentElem < 0) {
                array.setElement(i, number);
            }
        }
        logger.info("All the negative elements of the array {} has been replaced by {}", array.toString(), number);
        return array;
    }

    public IntArray replaceHigher100ElementsTo(IntArray array, int number) {
        for (int i = 0; i < array.length(); i++) {
            int currentElem = array.getElement(i);
            if(currentElem > 100) {
                array.setElement(i, number);
            }
        }
        logger.info("Each element is higher than 100 of the array {} has been replaced by {}", array.toString(), number);
        return array;
    }
}
