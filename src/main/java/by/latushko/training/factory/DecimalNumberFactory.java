package by.latushko.training.factory;

import by.latushko.training.entity.DecimalNumber;

public class DecimalNumberFactory {
    public static DecimalNumber produceNumber(double value) {
        return new DecimalNumber(value);
    }
}
