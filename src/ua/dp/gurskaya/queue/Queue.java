package ua.dp.gurskaya.queue;

public interface Queue <E> {

    void push(E element);
    E pop();
    boolean isEmpty();
    int size();

}
