package service;

import entity.IntArray;

public interface IntArraySortingService {
    IntArray bubbleSort(IntArray array);

    IntArray selectionSort(IntArray array);

    IntArray insertionSort(IntArray array);
}
