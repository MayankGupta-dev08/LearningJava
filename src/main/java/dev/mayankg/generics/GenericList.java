package dev.mayankg.generics;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * GenericList - for all Numeric types and User class objects | Iterable and Iterator interfaces
 */

class GenericList<T extends Comparable<T>> implements Iterable<T> {
    private T[] list;
    private int count;

    public GenericList(Class<T> tClass, int size) {
//        this.list = (T[]) new Object[size]; "Runtime error: ClassCastException"
        this.list = (T[]) Array.newInstance(tClass, size);
        this.count = 0;
    }

    void add(T item) {
        this.list[count++] = item;
    }

    T get(int index) {
        if (index < 0 || index >= list.length)
            throw new UnsupportedOperationException(index + " should be less than " + list.length);
        return list[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(this);
    }

    private class ListIterator<T extends Comparable<T>> implements Iterator<T> {
        private GenericList<T> listI;
        private int index = 0;

        public ListIterator(GenericList<T> listI) {
            this.listI = listI;
        }

        @Override
        public boolean hasNext() {
            return (index < listI.count);
        }

        @Override
        public T next() {
            return listI.list[index++];
        }
    }
}