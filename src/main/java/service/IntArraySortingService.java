package service;

import entity.IntArray;

public interface IntArraySortingService {
    public IntArray bubbleSort(IntArray array);
    public IntArray selectionSort(IntArray array);
    public IntArray insertionSort(IntArray array);
}
