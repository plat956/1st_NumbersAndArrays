package by.latushko.training.entity;

import by.latushko.training.exception.IntArrayException;

import java.util.Arrays;

public class IntArray {
    private int[] internalArray;

    public IntArray(int size) throws IntArrayException {
        if(size < 0) {
            throw new IntArrayException("You can't make an array with negative size");
        }
        this.internalArray = new int[size];
    }

    public IntArray(int... elems) {
        this.internalArray = Arrays.copyOf(elems, elems.length);
    }

    public int length() {
        return internalArray.length;
    }

    public int getElement(int index) throws IntArrayException {
        if(!checkIndex(index)) {
            throw new IntArrayException("Index " + index +   " is wrong");
        }
        return internalArray[index];
    }

    public void setElement(int index, int value) throws IntArrayException {
        if(!checkIndex(index)) {
            throw new IntArrayException("Index " + index +   " is wrong");
        }
        internalArray[index] = value;
    }

    public int[] getInternalArray() {
        return internalArray;
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < internalArray.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntArray intArray = (IntArray) o;

        return Arrays.equals(internalArray, intArray.internalArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(internalArray);
    }

    @Override
    public String toString() {
        return Arrays.toString(internalArray);
    }
}
