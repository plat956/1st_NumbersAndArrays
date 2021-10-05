package service;

import entity.DecimalNumber;

public interface ArithmeticsService {
    DecimalNumber round(DecimalNumber number, int places);

    DecimalNumber add(DecimalNumber firstNumber, DecimalNumber secondNumber);

    DecimalNumber add(DecimalNumber... numbers);

    DecimalNumber sub(DecimalNumber firstNumber, DecimalNumber secondNumber);

    DecimalNumber sub(DecimalNumber... numbers);

    DecimalNumber multiply(DecimalNumber firstNumber, DecimalNumber secondNumber);

    DecimalNumber multiply(DecimalNumber... numbers);

    DecimalNumber divide(DecimalNumber firstNumber, DecimalNumber secondNumber);

    DecimalNumber divide(DecimalNumber... numbers);
}
