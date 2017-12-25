package ua.dp.gurskaya.datastuctures.list;

public interface List<E> {

    void add(E object);

    void add(E object, int index);

    void remove(E object);

    void remove(int index);

    boolean isEmpty();

    int size();

    E get(int index);

    void set(E object, int index);

    void clear();

    int lastIndexOf(E object);

    int indexOf(E object);

}
