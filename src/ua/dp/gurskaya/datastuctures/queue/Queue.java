package ua.dp.gurskaya.datastuctures.queue;

public interface Queue<E> {

    void push(E element);
    E pop();
    boolean isEmpty();
    int size();

}
