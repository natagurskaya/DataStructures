package ua.dp.gurskaya.datastuctures.queue;

public class Node<E>  {
    private E value;
    private Node<E> next;

    public Node(E element) {
        this.value = element;
    }


    public E getValue() {
        return value;
    }

    public Node<E> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

    public void setValue(E value) {
        this.value = value;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}

