package ua.dp.gurskaya.datastuctures.map;

import java.util.*;

public class HashMap<K, V> implements Map<K, V> {

    private Node[] table;
    private int size;

    public HashMap() {
        table = new Node[16];
    }

    public HashMap(int capacity) {
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
        int index = findIndex(key, table.length);
        for (Node<K, V> node = table[index]; node != null; node = node.getNext()) {
            if (node.getKey().equals(key)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Node aTable : table) {
            for (Node<K, V> node = aTable; node != null; node = node.getNext()) {
                if (node.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        V value = null;
        if (key == null) {
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
        if (key == null) {
            putForNullKey(value);
        } else {
            int index = findIndex(key, table.length);
            Node<K, V> newNode = new Node<>(key, value);
            if (table[index] == null) {
                table[index] = newNode;
            } else if (containsKeyInBucket(key, index)) {
                Node<K, V> temp = getByKeyInBucket(key, index);
                temp.setValue(value);
                size--;
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

        Set<K> set = new HashSet<>();
        for (Node aTable : table) {
            for (Node<K, V> temp = aTable; temp != null; temp = temp.getNext()) {
                set.add(temp.getKey());
            }
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        Collection<V> collection = new HashSet<>();
        for (Node aTable : table) {
            for (Node<K, V> temp = aTable; temp != null; temp = temp.getNext()) {
                collection.add(temp.getValue());
            }
        }
        return collection;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {

        Set<Entry<K, V>> set = new HashSet<>();
        for (Node aTable : table) {
            for (Node<K, V> temp = aTable; temp != null; temp = temp.getNext()) {
                set.add((Entry<K, V>) temp);
            }
        }
        return set;
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
            size--;
        }
    }

    private Node<K, V> getByKeyInBucket(Object key, int index) {
        for (Node<K, V> node = table[index]; node != null; node = node.getNext()) {
            if (node.getKey() == key) {
                return node;
            }
        }
        throw new NoSuchElementException("No element found");
    }

    private V getFromNullKey() {
        for (Node<K, V> node = table[0]; node != null; node = node.getNext()) {
            if (node.getKey() == null) {
                return node.getValue();
            }
        }
        throw new NoSuchElementException("No element found");
    }

    private boolean containsKeyInBucket(Object key, int index) {
        for (Node<K, V> node = table[index]; node != null; node = node.getNext()) {
            if (node.getKey()==key) {
                return true;
            }
        }
        return false;
    }

    private Set<Node<K, V>> getNodeSet() {
        Set<Node<K, V>> set = new HashSet<>();
        for (Node aTable : table) {
            for (Node<K, V> temp = aTable; temp != null; temp = temp.getNext()) {
                set.add(temp);
            }
        }
        return set;
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "table=" + Arrays.toString(table) +
                ", size=" + size +
                '}';
    }
}

