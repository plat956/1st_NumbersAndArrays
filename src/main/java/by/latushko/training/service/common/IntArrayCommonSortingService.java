package by.latushko.training.service.common;

import by.latushko.training.entity.IntArray;
import by.latushko.training.exception.IntArrayInternalException;

public abstract class IntArrayCommonSortingService {
    protected void swap(IntArray array, int index1, int index2) throws IntArrayInternalException {
        int temp = array.getElement(index1);
        array.setElement(index1, array.getElement(index2));
        array.setElement(index2, temp);
    }
}
