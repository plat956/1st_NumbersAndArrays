package factory;

import entity.DecimalNumber;

public class DecimalNumberFactory {
    public static DecimalNumber produceNumber(double value) {
        return new DecimalNumber(value);
    }
}
