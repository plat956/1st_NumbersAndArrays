package service;

import entity.DecimalNumber;

public interface ArithmeticsService {
    public DecimalNumber round(DecimalNumber number, int places);

    public DecimalNumber add(DecimalNumber firstNumber, DecimalNumber secondNumber);

    public DecimalNumber add(DecimalNumber... numbers);

    public DecimalNumber sub(DecimalNumber firstNumber, DecimalNumber secondNumber);

    public DecimalNumber sub(DecimalNumber... numbers);

    public DecimalNumber multiply(DecimalNumber firstNumber, DecimalNumber secondNumber);

    public DecimalNumber multiply(DecimalNumber... numbers);

    public DecimalNumber divide(DecimalNumber firstNumber, DecimalNumber secondNumber);

    public DecimalNumber divide(DecimalNumber... numbers);
}
