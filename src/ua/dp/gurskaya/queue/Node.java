package ua.dp.gurskaya.queue;

public class Node<E>  {
    private E value;
    private Node next;

    public Node(E element) {
        this.value = element;
    }


    public E getValue() {
        return value;
    }

    public Node getNext() {
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

    public void setNext(Node next) {
        this.next = next;
    }
}

