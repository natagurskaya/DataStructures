package ua.dp.gurskaya.list;

public interface List<E> {

    public void add(E object);

    public void add(E object, int index);

    public void remove(E object);

    public void remove(int index);

    public boolean isEmpty();

    public int size();

    public E get(int index);

    public void set(E object, int index);

    public void clear();

    public int lastIndexOf(E object);

    public int indexOf(E object);

}
