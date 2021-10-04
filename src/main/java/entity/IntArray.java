package entity;

import java.util.Arrays;

public class IntArray {
    private int[] array;

    public IntArray(int size) {
        this.array = new int[size];
    }

    public IntArray(int... elems) {
        this.array = Arrays.copyOf(elems, elems.length);
    }

    public int length() {
        return array.length;
    }

    public int getElement(int index) {
        return array[index];
    }

    public void setElement(int index, int value) {
        array[index] = value;
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
