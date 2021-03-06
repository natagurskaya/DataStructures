package ua.dp.gurskaya.datastuctures.stack;

public class Node<E> {
    private E value;
    private Node<E> previous;

    Node (E value){
        this.value = value;
    }

    public E getValue() {

        return value;
    }

    public Node<E> getPrevious() {

        return previous;
    }

    public void setValue(E value) {

        this.value = value;
    }

    public void setPrevious(Node<E> previous) {

        this.previous = previous;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + previous +
                '}';
    }
}