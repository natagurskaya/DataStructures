package ua.dp.gurskaya.datastuctures.list;

public class LinkedList<E> implements List<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public void add(E object) {
        add(object, size);
    }

    public void add(E object, int index) {
        validateAddingIndex(index);
        Node<E> newNode = new Node<>(object);
        if (isEmpty()) {
            first = last = newNode;
        } else if (index == 0) {
            first.setPrevious(newNode);
            newNode.setNext(first);
            first = newNode;
        } else if (index == size) {
            last.setNext(newNode);
            newNode.setPrevious(last);
            last = newNode;
        } else {
            Node<E> after = getNode(index);
            Node<E> before = after.getPrevious();
            newNode.setNext(after);
            newNode.setPrevious(before);
            after.setPrevious(newNode);
            before.setNext(newNode);
        }
        size++;
    }

    public void remove(E object) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        Node<E> current = first;
        if (size == 1) {
            first = last = null;
        } else if (object.equals(first.getValue())) {
            first = first.getNext();
            first.getPrevious().setNext(null);
            first.setPrevious(null);
        } else if (object.equals(last.getValue())) {
            last = last.getPrevious();
            last.getNext().setPrevious(null);
            last.setNext(null);
        } else {
            while (current.getValue() != object) {
                current = current.getNext();
            }
            Node<E> after = current.getNext();
            Node<E> before = current.getPrevious();
            before.setNext(after);
            after.setPrevious(before);
        }
        size--;
    }

    public void remove(int index) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        validateIndex(index);
        if (size == 1) {
            first = last = null;
        } else if (index == 0) {
            first = first.getNext();
            first.getPrevious().setNext(null);
            first.setPrevious(null);
        } else if (index == size - 1) {
            last = last.getPrevious();
            last.getNext().setPrevious(null);
            last.setNext(null);
        } else {
            Node<E> before = getNode(index).getPrevious();
            Node<E> after = getNode(index).getNext();
            before.setNext(after);
            after.setPrevious(before);
        }
        size--;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty, could not get an object");
        }
        validateIndex(index);
        if (index == 0) {
            return first.getValue();
        } else if (index == size - 1) {
            return last.getValue();
        } else {
            return getNode(index).getValue();
        }
    }

    public void set(E object, int index) {
        validateIndex(index);
        if (index == 0) {
            first.setValue(object);
        } else if (index == size - 1) {
            last.setValue(object);
        } else {
            getNode(index).setValue(object);
        }
    }

    public void clear() {
        Node<E> current = first;
        while (current.getNext() != null) {
            current.setValue(null);
            current.setPrevious(null);
            current.setNext(null);
        }
        last = first = null;
        size = 0;
    }

    public int lastIndexOf(E element) {
        Node<E> result = last;
        for (int i = size - 1; i >= 0; i--) {
            if (element.equals(result.getValue())) {
                return i;
            }
            result = result.getPrevious();
        }
        return -1;
    }

    public int indexOf(E object) {
        Node result = first;
        for (int i = 0; i < size; i++) {
            if (object.equals(result.getValue())) {
                return i;
            }
            result = result.getNext();
        }
        return -1;
    }

    private Node<E> getNode(int index) {
        if (index < size / 2) {
            Node<E> current = first;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current;
        } else {
            Node<E> current = last;
            for (int i = size - 1; i > index; i--) {
                current = current.getPrevious();
            }
            return current;
        }
    }

    private void validateAddingIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index should be between 0 (inclusive) and " + size + "(inclusive)");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index should be between 0 (inclusive) and " + (size - 1) + "(inclusive)");
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<E> current = first;
        result.append(current.getValue()).append(", ");
        while (current.getNext() != null){
            current = current.getNext();
            result.append(current.getValue()).append(", ");
        }
        return result.toString();
    }
}
