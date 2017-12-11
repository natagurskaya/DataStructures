package ua.dp.gurskaya.queue;

public class LinkedQueue<E> implements Queue<E> {

    private Node first;
    private int size;

    @Override
    public void push(E element) {
        Node newNode = new Node(element);
        if (isEmpty()){
            first = newNode;
            first.setValue(element);
        } else {
            Node temp = first;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setValue(element);
        }
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()){
            throw new RuntimeException("ArrayQueue is empty!");
        }
        E result = (E)first.getValue();
        first = first.getNext();
        size--;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return "LinkedQueue{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }
}