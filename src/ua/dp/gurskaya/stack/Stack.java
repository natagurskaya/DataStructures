package ua.dp.gurskaya.stack;

public interface Stack<E> {

    void push(E object);

    E pop();

    boolean isEmpty();

    boolean isFull();

    int size();
}
