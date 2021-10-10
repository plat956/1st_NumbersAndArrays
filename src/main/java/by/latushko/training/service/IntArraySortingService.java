package by.latushko.training.service;

import by.latushko.training.entity.IntArray;

public interface IntArraySortingService {
    void bubbleSort(IntArray array);

    void selectionSort(IntArray array);

    void insertionSort(IntArray array);
}
