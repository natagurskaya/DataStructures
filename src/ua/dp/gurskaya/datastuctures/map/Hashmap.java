package ua.dp.gurskaya.datastuctures.map;

import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Hashmap<K, V> implements Map<K, V> {

    private Node[] table;
    private int size;

    public Hashmap() {
        table = new Node[16];
    }

    public Hashmap(int capacity) {
        table = new Node[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return table.length == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        for (Node<K, V> node = table[0]; node != null; node = node.getNext()) {
            if (node.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Node<K, V> node = table[0]; node != null; node = node.getNext()) {
            if (node.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        V value = null;
        if (key.equals(null)) {
            if (containsKeyInBucket(key, 0)) {
                value = getFromNullKey();
            }
        } else {
            int index = findIndex(key, table.length);
            if (containsKeyInBucket(key, index)) {
                Node<K, V> temp = getByKeyInBucket(key, index);
                value = temp.getValue();
            }
        }
        return value;
    }

    @Override
    public V put(K key, V value) {
        if (key.equals(null)) {
            putForNullKey(value);
        } else {
            int index = findIndex(key, table.length);
            Node<K, V> newNode = new Node<>(key, value);
            if (table[index] == null) {
                table[index] = newNode;
            } else if (containsKeyInBucket(key, index)) {
                Node<K, V> temp = getByKeyInBucket(key, index);
                temp.setValue(value);
            } else {
                Node<K, V> temp = table[index];
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                temp.setNext(newNode);
            }
        }
        size++;
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    private int findIndex(Object key, int capacity) {
        int keyHashCode = key.hashCode();
        return keyHashCode % capacity;
    }

    private void putForNullKey(V value) {
        Node<K, V> newNode;
        if (table[0] == null) {
            newNode = new Node<>(null, value);
            table[0] = newNode;
        } else {
            newNode = getByKeyInBucket(null, 0);
            newNode.setValue(value);
        }
    }

    private Node<K, V> getByKeyInBucket(Object key, int index) {
        for (Node<K, V> node = table[index]; node != null; node = node.getNext()) {
            if (node.getKey().equals(key)) {
                return node;
            }
        }
        throw new NoSuchElementException("No element found");
    }

    private V getFromNullKey() {
        for (Node<K, V> node = table[0]; node != null; node = node.getNext()) {
            if (node.getKey().equals(null)) {
                return node.getValue();
            }
        }
        throw new NoSuchElementException("No element found");
    }


    private boolean containsKeyInBucket(Object key, int index) {
        for (Node<K, V> node = table[index]; node != null; node = node.getNext()) {
            if (node.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

}
