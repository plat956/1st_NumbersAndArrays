package by.latushko.training.service;

import by.latushko.training.entity.DecimalNumber;
import by.latushko.training.entity.IntArray;

public interface IntArrayBasicService {
    int findMin(IntArray array);

    int findMax(IntArray array);

    int calculateSum(IntArray array);

    DecimalNumber calculateAverage(IntArray array);

    int countNegativeValues(IntArray array);

    int countPositiveValues(IntArray array);

    IntArray replaceNegativeElementsTo(IntArray array, int number);

    IntArray replaceHigherThan100ElementsTo(IntArray array, int number);
}
