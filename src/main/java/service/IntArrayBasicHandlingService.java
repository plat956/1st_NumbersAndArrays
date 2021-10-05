package service;

import entity.DecimalNumber;
import entity.IntArray;

public interface IntArrayBasicHandlingService {
    int getMin(IntArray array);

    int getMax(IntArray array);

    int getSum(IntArray array);

    DecimalNumber getAverage(IntArray array);

    int getNegativeCount(IntArray array);

    int getPositiveCount(IntArray array);

    IntArray replaceNegativeElementsTo(IntArray array, int number);

    IntArray replaceHigher100ElementsTo(IntArray array, int number);
}
