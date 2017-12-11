package ua.dp.gurskaya.stack;

public class Node<E> {
    private E value;
    private Node previous;

    Node (E value){
        this.value = value;
    }

    public E getValue() {

        return value;
    }

    public Node getPrevious() {

        return previous;
    }

    public void setValue(E value) {

        this.value = value;
    }

    public void setPrevious(Node previous) {

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