package service;

import entity.DecimalNumber;
import entity.IntArray;

public interface IntArrayBasicHandlingService {
    public int getMin(IntArray array);

    public int getMax(IntArray array);

    public int getSum(IntArray array);

    public DecimalNumber getAverage(IntArray array);

    public int getNegativeCount(IntArray array);

    public int getPositiveCount(IntArray array);

    public IntArray replaceNegativeElementsTo(IntArray array, int number);

    public IntArray replaceHigher100ElementsTo(IntArray array, int number);
}
