package service.Impl;

import entity.DecimalNumber;
import factory.DecimalNumberFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.ArithmeticsService;

import java.util.Arrays;

public class ArithmeticsServiceImpl implements ArithmeticsService {
    private static final Logger logger = LogManager.getLogger();

    public DecimalNumber round(DecimalNumber number, int places) {
        double value = (double) Math.round(number.getValue() * 100) / 100;
        return DecimalNumberFactory.produceNumber(value);
    }

    public DecimalNumber add(DecimalNumber firstNumber, DecimalNumber secondNumber) {
        double tempNumber = firstNumber.getValue() + secondNumber.getValue();
        logger.info("Addition of numbers {}, {} is {}", firstNumber, secondNumber, tempNumber);
        return DecimalNumberFactory.produceNumber(tempNumber);
    }

    public DecimalNumber add(DecimalNumber... numbers) {
        double tempNumber = 0.0d;
        for (DecimalNumber i: numbers) {
            tempNumber += i.getValue();
        }
        logger.info("Addition result of numbers {} is: {}", Arrays.toString(numbers), tempNumber);
        return DecimalNumberFactory.produceNumber(tempNumber);
    }

    public DecimalNumber sub(DecimalNumber firstNumber, DecimalNumber secondNumber) {
        double tempNumber = firstNumber.getValue() - secondNumber.getValue();
        logger.info("Subtraction of numbers {}, {} is {}", firstNumber, secondNumber, tempNumber);
        return DecimalNumberFactory.produceNumber(tempNumber);
    }

    public DecimalNumber sub(DecimalNumber... numbers) {
        double tempNumber = numbers.length > 0 ? numbers[0].getValue() : 0.0d;

        for (int i = 1; i < numbers.length; i++) {
            tempNumber -= numbers[i].getValue();
        }
        logger.info("Subtraction of numbers {} is {}", Arrays.toString(numbers), tempNumber);
        return DecimalNumberFactory.produceNumber(tempNumber);
    }

    public DecimalNumber multiply(DecimalNumber firstNumber, DecimalNumber secondNumber) {
        double tempNumber = firstNumber.getValue() * secondNumber.getValue();
        logger.info("Multiplication of numbers {}, {} is {}", firstNumber, secondNumber, tempNumber);
        return DecimalNumberFactory.produceNumber(tempNumber);
    }

    public DecimalNumber multiply(DecimalNumber... numbers) {
        double tempNumber = numbers.length > 0 ? 1.0d : 0.0d;
        for (DecimalNumber i: numbers) {
            tempNumber *= i.getValue();
        }
        logger.info("Multiplication of numbers {} is {}", Arrays.toString(numbers), tempNumber);
        return DecimalNumberFactory.produceNumber(tempNumber);
    }

    public DecimalNumber divide(DecimalNumber firstNumber, DecimalNumber secondNumber) {
        double tempNumber = firstNumber.getValue() / secondNumber.getValue();
        logger.info("Division of numbers {}, {} is {}", firstNumber, secondNumber, tempNumber);
        return DecimalNumberFactory.produceNumber(tempNumber);
    }

    public DecimalNumber divide(DecimalNumber... numbers) {
        double tempNumber = numbers.length > 0 ? numbers[0].getValue() : 0.0d;

        for (int i = 1; i < numbers.length; i++) {
            tempNumber /= numbers[i].getValue();
        }
        logger.info("Division of numbers {} is {}", Arrays.toString(numbers), tempNumber);
        return DecimalNumberFactory.produceNumber(tempNumber);
    }
}
