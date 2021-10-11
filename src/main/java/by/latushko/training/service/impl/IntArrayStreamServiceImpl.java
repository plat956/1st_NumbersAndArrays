package by.latushko.training.service.impl;

import by.latushko.training.entity.DecimalNumber;
import by.latushko.training.entity.IntArray;
import by.latushko.training.exception.IntArrayException;
import by.latushko.training.factory.DecimalNumberFactory;
import by.latushko.training.service.IntArrayStreamService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class IntArrayStreamServiceImpl implements IntArrayStreamService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public OptionalInt findMin(IntArray array) {
        try {
            int min = IntStream.of(array.getInternalArray()).min().orElseThrow(IntArrayException::new);
            logger.info("The smallest element of the array {} is {}", array.toString(), min);
            return OptionalInt.of(min);
        } catch (IntArrayException e) {
            logger.error("Haven't managed to determine the smallest element", e);
            return OptionalInt.empty();
        }
    }

    @Override
    public OptionalInt findMax(IntArray array) {
        try {
            int max = IntStream.of(array.getInternalArray()).max().orElseThrow(IntArrayException::new);
            logger.info("The biggest element of the array {} is {}", array.toString(), max);
            return OptionalInt.of(max);
        } catch (IntArrayException e) {
            logger.error("Haven't managed to determine the biggest element", e);
            return OptionalInt.empty();
        }
    }

    @Override
    public int calculateSum(IntArray array) {
        int sum = IntStream.of(array.getInternalArray()).sum();
        logger.info("Total amount of the array elements {} is {}", array.toString(), sum);
        return sum;
    }

    @Override
    public Optional<DecimalNumber> calculateAverage(IntArray array) {
        try {
            double average = IntStream.of(array.getInternalArray()).average().orElseThrow(IntArrayException::new);
            logger.info("The average element of the array {} is {}", array.toString(), average);
            DecimalNumber number = DecimalNumberFactory.produceNumber(average);
            return Optional.of(number);
        } catch (IntArrayException e) {
            logger.error("Haven't managed to calculate the average value of elements", e);
            return Optional.empty();
        }
    }

    @Override
    public long countNegativeValues(IntArray array) {
        long count = IntStream.of(array.getInternalArray()).filter(element -> element < 0).count();
        logger.info("The the array {} contains {} negative elements", array.toString(), count);
        return count;
    }

    @Override
    public long countPositiveValues(IntArray array) {
        long count = IntStream.of(array.getInternalArray()).filter(element -> element > 0).count();
        logger.info("The the array {} contains {} positive elements", array.toString(), count);
        return count;
    }

    @Override
    public IntArray replaceNegativeElementsTo(IntArray array, int number) {
        int[] tempArray = IntStream.of(array.getInternalArray()).map(element -> element < 0 ? number : element).toArray();
        IntArray result = new IntArray(tempArray);
        logger.info("All the negative elements of the array {} has been replaced by {}", result.toString(), number);
        return result;
    }

    @Override
    public IntArray replaceHigherThan100ElementsTo(IntArray array, int number) {
        int[] tempArray = IntStream.of(array.getInternalArray()).map(element -> element > 100 ? number : element).toArray();
        IntArray result = new IntArray(tempArray);
        logger.info("Each element is higher than 100 of the array {} has been replaced by {}", result.toString(), number);
        return result;
    }
}
