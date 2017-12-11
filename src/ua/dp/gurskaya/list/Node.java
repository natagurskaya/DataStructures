package ua.dp.gurskaya.list;

public class Node<E> {
    private E value;
    private Node next;
    private Node previous;

    public Node(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                ", previous=" + previous +
                '}';
    }

    public void displayNode(){
        System.out.println(value);
    }
}
