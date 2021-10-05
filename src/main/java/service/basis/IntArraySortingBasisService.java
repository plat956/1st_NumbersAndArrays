package service.basis;

import entity.IntArray;

public abstract class IntArraySortingBasisService {
    protected void swap(IntArray array, int index1, int index2) {
        int temp = array.getElement(index1);
        array.setElement(index1, array.getElement(index2));
        array.setElement(index2, temp);
    }
}
