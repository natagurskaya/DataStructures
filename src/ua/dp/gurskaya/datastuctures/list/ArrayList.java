package ua.dp.gurskaya.datastuctures.list;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {
    private E[] array;
    private int size;

    public ArrayList(int capacity) {
        if (capacity <= 0){
            throw new IllegalArgumentException("Capacity should be more than 0!");
        } else {
            array = (E[]) new Object[capacity];
        }
    }

    public void add(E object) {
        if (size == array.length) {
            reSize();
        }
        add(object, size);
    }

    public void add(E object, int index) {
        validateAddingIndex(index);
        if (size == array.length){
            reSize();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = object;
        size++;
    }

    public void remove(E object) {
        if (isEmpty()) {
            System.out.println("list is empty, could not remove an object");
        }else {
            for (int i = 0; i < size; i++) {
                if (object.equals(array[i])) {
                    remove(i);
                }
            }
        }
    }

    public void remove(int index) {
        if (isEmpty()) {
            System.out.println("list is empty, could not remove an object");
        }else {
            validateIndex(index);
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
            size--;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if (isEmpty()) {
            throw new RuntimeException("list is empty, could not get an object");
        }else {
            validateIndex(index);
            return array[index];
        }
    }

    public void set(E object, int index) {
        validateIndex(index);
        array[index] = object;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int indexOf(E object) {
        for (int i=0; i<size; i++){
            if (object.equals(array[i])){
                return i;
            }
        }
        return -1;
    }
    public int lastIndexOf(Object object) {
        for (int i=size-1; i>=0; i--){
            if (object.equals(array[i])){
                return i;
            }
        }
        return -1;
    }

    private void validateAddingIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index should be between 0 (inclusive) and " + size + "(inclusive)");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size-1) {
            throw new IndexOutOfBoundsException("Index should be between 0 (inclusive) and " + (size - 1) + "(inclusive)");
        }
    }

    private void reSize(){
        if (array.length == 0){
            array = (E[]) new Object[1];
        }
        E[] newArray = (E[]) new Object[array.length*2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public String toString() {
        Object [] arrayToPrint = new Object[size];
        System.arraycopy(array, 0, arrayToPrint, 0, size);
        return Arrays.toString(arrayToPrint);
    }
}
