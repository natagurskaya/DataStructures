package ua.dp.gurskaya.queue;

public class ArrayQueue<E> implements Queue<E> {
    private E [] array;
    private int size;

    public ArrayQueue(int capacity) {
        if (capacity <= 0){
            throw new IllegalArgumentException("Capacity should be more than 0!");
        } else {
            array = (E[]) new Object [capacity];
        }
    }

    public void push(E element) {
            resize();
            array[size] = element;
            size++;
        }

    public E pop() {
        if(isEmpty()) {
            throw new RuntimeException("ArrayQueue is empty!");
        }
            E result = array[0];
            System.arraycopy(array,1, array,0,size-1);
            size--;
            return result;
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public boolean isFull() {

        return size == array.length;
    }

    public int size(){ return size;}

    private void resize() {
        if(isFull()) {
            E[] newArray = (E[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

}
