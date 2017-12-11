package ua.dp.gurskaya.stack;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {
    private E[] array;
    private int size;

    public ArrayStack(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity should be more than 0!");
        } else {
            array = (E[]) new Object[capacity];
        }
    }

    public void push(E element) {
        resize();
        array[size] = element;
        size++;
    }

    public E pop() {
        E element = null;
        if (!isEmpty()) {
            element = array[size - 1];
            size--;
        }
        return element;
    }

    @Override
    public String toString() {
        return "stack{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public int size() {
        return size;
    }

    private void resize() {
        if(isFull()) {
            E[] newArray = (E[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

}
