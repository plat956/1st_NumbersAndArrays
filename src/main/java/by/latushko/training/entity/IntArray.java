package by.latushko.training.entity;

import by.latushko.training.exception.IntArrayException;

import java.util.Arrays;

public class IntArray {
    private int[] array;

    public IntArray(int size) throws IntArrayException {
        if(size < 0) {
            throw new IntArrayException("You can't make an array with negative size");
        }
        this.array = new int[size];
    }

    public IntArray(int... elems) {
        this.array = Arrays.copyOf(elems, elems.length);
    }

    public int length() {
        return array.length;
    }

    public int getElement(int index) throws IntArrayException {
        if(!checkIndex(index)) {
            throw new IntArrayException("Index " + index +   " is wrong");
        }
        return array[index];
    }

    public void setElement(int index, int value) throws IntArrayException {
        if(!checkIndex(index)) {
            throw new IntArrayException("Index " + index +   " is wrong");
        }
        array[index] = value;
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < array.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntArray intArray = (IntArray) o;

        return Arrays.equals(array, intArray.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
