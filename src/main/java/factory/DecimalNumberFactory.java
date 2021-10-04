package factory;

import entity.DecimalNumber;

public class DecimalNumberFactory {
    public static DecimalNumber produceNumber(double value) {
        return new DecimalNumber(value);
    }

    public static DecimalNumber produceNumber() {
        return new DecimalNumber(0.0d);
    }

    public static DecimalNumber[] produceArray(int size) {
        return new DecimalNumber[size];
    }
}
