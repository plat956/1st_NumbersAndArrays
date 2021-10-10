package by.latushko.training.service.impl;

import by.latushko.training.entity.DecimalNumber;
import by.latushko.training.entity.IntArray;
import by.latushko.training.service.IntArrayBasicService;
import by.latushko.training.service.common.IntArrayCommonSortingService;

public class IntArrayStreamBasicServiceImpl extends IntArrayCommonSortingService implements IntArrayBasicService {

    @Override
    public int findMin(IntArray array) {
        return 0;
    }

    @Override
    public int findMax(IntArray array) {
        return 0;
    }

    @Override
    public int calculateSum(IntArray array) {
        return 0;
    }

    @Override
    public DecimalNumber calculateAverage(IntArray array) {
        return null;
    }

    @Override
    public int countNegativeValues(IntArray array) {
        return 0;
    }

    @Override
    public int countPositiveValues(IntArray array) {
        return 0;
    }

    @Override
    public IntArray replaceNegativeElementsTo(IntArray array, int number) {
        return null;
    }

    @Override
    public IntArray replaceHigherThan100ElementsTo(IntArray array, int number) {
        return null;
    }
}
