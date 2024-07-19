package dev.mayankg.ds_algo_patterns.dataStructures.dynamicArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings({"unused", "unchecked"})
public class DynamicArray<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 1 << 3; //8

    private T[] arr;
    private int length = 0; //size of the array for user
    private int capacity = 0;   //actual size of the array

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T elem) {
        arr[index] = elem;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++)
            arr[i] = null;
        this.length = 0;
    }

    public void add(T elem) {
        if (length == capacity) {
            if (capacity == 0) capacity = 1;
            else capacity = 2 * capacity;
            T[] temp = (T[]) new Object[capacity];
            for (int i = 0; i < length; i++)
                temp[i] = arr[i];
            arr = temp;
        }
        arr[length++] = elem;   //should happen in all cases
    }

    public T removeAt(int index) {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();
        T removedElement = arr[index];
        for (int i = index; i < length; i++)
            arr[i] = arr[i + 1];
        arr[length - 1] = null;
        length -= 1;
        return removedElement;
    }

    public boolean remove(T elem) {
        int index = indexOf(elem);
        if (index != -1) {
            removeAt(index);
            return true;
        }
        return false;
    }

    public int indexOf(T elem) {
        for (int i = 0; i < size(); i++)
            if (arr[i].equals(elem))
                return i;
        return -1;
    }

    public boolean contains(T elem) {
        return indexOf(elem) != -1;
    }

    /**
     * Makes Array<T> class compatible with enhanced for loops (forEach loop).
     * Also ensure compatibility with Java's collection framework.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < length;
            }

            @Override
            public T next() {
                if(!hasNext())
                    throw new NoSuchElementException();
                return arr[currentIndex++];
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < length - 1; i++)
            stringBuilder.append(arr[i]).append(", ");
        stringBuilder.append(arr[length - 1]).append("]");
        return stringBuilder.toString();
    }
}
