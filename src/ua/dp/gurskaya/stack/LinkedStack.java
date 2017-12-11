package ua.dp.gurskaya.stack;

public class LinkedStack<E> implements Stack<E> {

    private Node last;
    private int size;

    @Override
    public void push(E object) {
        Node previous = last;
        last = new Node(object);
        last.setPrevious(previous);
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        E result = (E) last.getValue();
        last = last.getPrevious();
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
    public boolean isFull() {
        return false;
    }
}
