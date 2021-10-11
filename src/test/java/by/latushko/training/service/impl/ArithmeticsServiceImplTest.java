package by.latushko.training.service.impl;

import by.latushko.training.entity.DecimalNumber;
import by.latushko.training.factory.DecimalNumberFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import by.latushko.training.service.ArithmeticsService;

import static org.testng.Assert.*;

public class ArithmeticsServiceImplTest {
    private ArithmeticsService arithmeticsService;

    @BeforeClass
    public void setUp() {
        arithmeticsService = new ArithmeticsServiceImpl();
    }

    @Test
    public void testAdd() {
        DecimalNumber expected = DecimalNumberFactory.produceNumber(7.55);

        DecimalNumber firstNumber = DecimalNumberFactory.produceNumber(5.22);
        DecimalNumber secondNumber = DecimalNumberFactory.produceNumber(2.33);
        DecimalNumber actual = arithmeticsService.add(firstNumber, secondNumber);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddMultiple() {
        DecimalNumber expected = DecimalNumberFactory.produceNumber(118.14);

        DecimalNumber firstNumber = DecimalNumberFactory.produceNumber(1.17);
        DecimalNumber secondNumber = DecimalNumberFactory.produceNumber(3.02);
        DecimalNumber thirdNumber = DecimalNumberFactory.produceNumber(0.00);
        DecimalNumber fourthNumber = DecimalNumberFactory.produceNumber(113.95);
        DecimalNumber actual = arithmeticsService.add(firstNumber, secondNumber, thirdNumber, fourthNumber);

        assertEquals(expected, actual);
    }

    @Test
    public void testDivide() {
        DecimalNumber expected = DecimalNumberFactory.produceNumber(2.71);

        DecimalNumber firstNumber = DecimalNumberFactory.produceNumber(5.42);
        DecimalNumber secondNumber = DecimalNumberFactory.produceNumber(2.00);
        DecimalNumber actual = arithmeticsService.divide(firstNumber, secondNumber);

        assertEquals(expected, actual);
    }

    @Test
    public void testDivideMultiple() {
        DecimalNumber expected = DecimalNumberFactory.produceNumber(-0.1);

        DecimalNumber firstNumber = DecimalNumberFactory.produceNumber(4.40);
        DecimalNumber secondNumber = DecimalNumberFactory.produceNumber(2.20);
        DecimalNumber thirdNumber = DecimalNumberFactory.produceNumber(0.50);
        DecimalNumber fourthNumber = DecimalNumberFactory.produceNumber(-40.00);
        DecimalNumber actual = arithmeticsService.divide(firstNumber, secondNumber, thirdNumber, fourthNumber);

        assertEquals(expected, actual);
    }

    @Test
    public void testDivideInfinity() {
        DecimalNumber expected = DecimalNumberFactory.produceNumber(Double.POSITIVE_INFINITY);

        DecimalNumber firstNumber = DecimalNumberFactory.produceNumber(5.42);
        DecimalNumber secondNumber = DecimalNumberFactory.produceNumber(0.00);
        DecimalNumber actual = arithmeticsService.divide(firstNumber, secondNumber);

        assertEquals(expected, actual);
    }

    @Test
    public void testMultiply() {
        DecimalNumber expected = DecimalNumberFactory.produceNumber(12.2325);

        DecimalNumber firstNumber = DecimalNumberFactory.produceNumber(5.25);
        DecimalNumber secondNumber = DecimalNumberFactory.produceNumber(2.33);
        DecimalNumber actual = arithmeticsService.multiply(firstNumber, secondNumber);

        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyMultiple() {
        DecimalNumber expected = DecimalNumberFactory.produceNumber(-20.84285);

        DecimalNumber firstNumber = DecimalNumberFactory.produceNumber(3.10);
        DecimalNumber secondNumber = DecimalNumberFactory.produceNumber(1.13);
        DecimalNumber thirdNumber = DecimalNumberFactory.produceNumber(1.00);
        DecimalNumber fourthNumber = DecimalNumberFactory.produceNumber(-5.95);
        DecimalNumber actual = arithmeticsService.multiply(firstNumber, secondNumber, thirdNumber, fourthNumber);

        assertEquals(expected, actual);
    }

    @Test
    public void testSub() {
        DecimalNumber expected = DecimalNumberFactory.produceNumber(2.92);

        DecimalNumber firstNumber = DecimalNumberFactory.produceNumber(5.25);
        DecimalNumber secondNumber = DecimalNumberFactory.produceNumber(2.33);
        DecimalNumber actual = arithmeticsService.sub(firstNumber, secondNumber);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubMultiple() {
        DecimalNumber expected = DecimalNumberFactory.produceNumber(3.93);

        DecimalNumber firstNumber = DecimalNumberFactory.produceNumber(1.10);
        DecimalNumber secondNumber = DecimalNumberFactory.produceNumber(3.12);
        DecimalNumber thirdNumber = DecimalNumberFactory.produceNumber(0.00);
        DecimalNumber fourthNumber = DecimalNumberFactory.produceNumber(-5.95);
        DecimalNumber actual = arithmeticsService.sub(firstNumber, secondNumber, thirdNumber, fourthNumber);

        assertEquals(expected, actual);
    }
}