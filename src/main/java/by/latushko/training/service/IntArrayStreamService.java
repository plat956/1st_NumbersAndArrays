package by.latushko.training.service;

import by.latushko.training.entity.DecimalNumber;
import by.latushko.training.entity.IntArray;

import java.util.Optional;
import java.util.OptionalInt;

public interface IntArrayStreamService {
    OptionalInt findMin(IntArray array);

    OptionalInt findMax(IntArray array);

    int calculateSum(IntArray array);

    Optional<DecimalNumber> calculateAverage(IntArray array);

    long countNegativeValues(IntArray array);

    long countPositiveValues(IntArray array);

    IntArray replaceNegativeElementsTo(IntArray array, int number);

    IntArray replaceHigherThan100ElementsTo(IntArray array, int number);
}
