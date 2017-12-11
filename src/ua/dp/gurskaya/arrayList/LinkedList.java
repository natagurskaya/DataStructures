package ua.dp.gurskaya.arrayList;

public class LinkedList <E> implements List <E> {

    private Node first;
    private int size;

    @Override
    public void add(E object) {
        Node newNode = new Node(object);
        if (isEmpty()){
            first = newNode;
        } else {
            Node result = first;
            while(result.getNext() != null){
                result = result.getNext();
            }
            result.setNext(newNode);
            newNode.setPrevious(result);
        }
        size++;
    }

    @Override
    public void add(E object, int index) {
        Node newNode = new Node(object);
        Node result = first;
        if (isEmpty()) {
            first = newNode;
        } else {
            for (int i = 0; i < index-1; i++) {
                result = result.getNext();
            }
            if (result.getNext() == null) {
                result.setNext(newNode);
                newNode.setPrevious(result);
            } else {
               // Node after = result;
               // Node before = result.getPrevious();
                Node after = result.getNext();
                Node before = result;

                before.setNext(newNode);
                after.setPrevious(newNode);
                newNode.setPrevious(before);
                newNode.setNext(after);
            }
        }
        size++;
    }

    @Override
    public void remove(E object) {
        int index = indexOf(object);
        remove(index);

    }

    @Override
    public void remove(int index) {
        if (isEmpty()){
            throw new RuntimeException("List is empty");
        }
        Node current = first;
        if (index == 0){
            first = current.getNext();
        } else {
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            if(current.getNext() == null){
                current.getPrevious().setNext(null);
            } else {
                Node beforeCurrent = current.getPrevious();
                Node afterCurrent = current.getNext();
                beforeCurrent.setNext(afterCurrent);
                afterCurrent.setPrevious(beforeCurrent);
            }
        }
        size --;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        Node result = first;
        if (index == 0){
            return (E) result.getValue();
        } else {
            for (int i = 0; i < index; i++) {
                result = result.getNext();
            }
            return (E) result.getValue();
        }
    }

    @Override
    public void set(E object, int index) {
        Node result = first;
        for (int i = 0; i < index; i++){
            result = result.getNext();
        }
        result.setValue(object);
    }

    @Override
    public void clear() {
       for(int i = 0; i<size; i++){
           remove(i);
       }
        size = 0;
    }

    @Override
    public int lastIndexOf(E object) {
        Node result = first;
        for(int j = 0; j < size-1; j++){
            result = result.getNext();
        }
        for(int i = size-1; i >= 0; i--){
            if(object.equals(result.getValue())){
                return i;
            } else {
                result = result.getPrevious();
            }
        }
        return -1;
    }

    @Override
    public int indexOf(E object) {
        Node result = first;
        for(int i = 0; i < size; i++){
            if(object.equals(result.getValue())){
                return i;
            } else {
                result = result.getNext();
            }
        }
        return -1;
    }

    public void display() {
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.getNext();
        }
    }
}
