package ua.dp.gurskaya.datastuctures.map;

import java.util.*;

public class HashMap<K, V> implements Map<K, V> {

    private Node<K, V>[] table;
    private int size;
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    public HashMap() {
        table = new Node[INITIAL_CAPACITY];
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
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int index;
        if (key == null) {
            for (Node node = table[0]; node != null; node = node.getNext()) {
                if (null == node.getKey()) {
                    return true;
                }
            }
        } else {
            index = findIndex(key, table.length);
            for (Node node = table[index]; node != null; node = node.getNext()) {
                if (key.equals(node.getKey())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) {
            for (Node<K, V> aTable : table) {
                if (aTable != null) {
                    for (Node<K, V> node = aTable; node != null; node = node.getNext()) {
                        if (null == node.getValue()) {
                            return true;
                        }
                    }
                }
            }
        } else {
            for (Node<K, V> aTable : table) {
                if (aTable != null) {
                    for (Node<K, V> node = aTable; node != null; node = node.getNext()) {
                        if (value.equals(node.getValue())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        if (key == null) {
            return getFromNullKey();
        } else {
            int index = findIndex(key, table.length);
            Node<K, V> node = table[index];
            while (node != null) {
                if (key.equals(node.getKey())) {
                    return node.getValue();
                } else {
                    node = node.getNext();
                }
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        resize();
        if (key == null) {
            return putForNullKey(value);
        } else {
            int index = findIndex(key, table.length);
            Node<K, V> newNode = new Node<>(key, value);
            if (table[index] == null) {
                table[index] = newNode;
            } else {
                Node<K, V> node;
                for (node = table[index]; node != null; node = node.getNext()) {
                    if (key.equals(node.getKey())) {
                        V oldValue = node.getValue();
                        node.setValue(value);
                        return oldValue;
                    } else if (node.getNext() == null) {
                        node.setNext(newNode);
                        size++;
                        return null;
                    }
                }
            }
        }
        size++;
        return null;
    }

    @Override
    public V remove(Object key) {
        int index;
        if (key == null) {
            index = 0;
        } else {
            index = findIndex(key, table.length);
        }
        V oldValue;
        Node<K, V> current = table[index];
        Node<K, V> previous = null;
        while (current.getKey()!=key) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null) {
            oldValue = current.getValue();
            current = null;
            return oldValue;
        } else if (current.getNext() == null) {
            oldValue = current.getValue();
            previous.setNext(null);
            return oldValue;
        } else if (current.getNext()!= null){
            oldValue = current.getValue();
            previous.setNext(current.getNext());
            return oldValue;
        } else {
            return null;
        }
     }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (Node<K, V> aTable : table) {
            for (Node<K, V> temp = aTable; temp != null; temp = temp.getNext()) {
                set.add(temp.getKey());
            }
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        Collection<V> collection = new HashSet<>();
        for (Node<K, V> aTable : table) {
            for (Node<K, V> temp = aTable; temp != null; temp = temp.getNext()) {
                collection.add(temp.getValue());
            }
        }
        return collection;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (Node<K, V> aTable : table) {
            for (Node<K, V> temp = aTable; temp != null; temp = temp.getNext()) {
                set.add(temp);
            }
        }
        return set;

    }

    private int findIndex(Object key, int capacity) {
        int keyHashCode = key.hashCode();
        return keyHashCode % capacity;
    }

    private V putForNullKey(V value) {
        Node<K, V> newNode = new Node<>(null, value);
        if (table[0] == null) {
            table[0] = newNode;
        } else {
            Node<K, V> node;
            for (node = table[0]; node != null; node = node.getNext()) {
                if (null == node.getKey()) {
                    V oldValue = node.getValue();
                    node.setValue(value);
                    return oldValue;
                } else if (node.getNext() == null) {
                    node.setNext(newNode);
                    size++;
                    return null;
                }
            }
        }
        size++;
        return null;
    }

    private V getFromNullKey() {
        for (Node<K, V> node = table[0]; node != null; node = node.getNext()) {
            if (node.getKey() == null) {
                return node.getValue();
            }
        }
        return null;
    }

    private void resize() {
        if (size >= table.length * LOAD_FACTOR) {
            Node<K, V>[] newTable = new Node[table.length * 2];
            transfer(newTable);
            table = newTable;

        }
    }

    private void transfer(Node<K, V>[] newTable) {
        int newCapacity = newTable.length;
        int index;
        for (Node<K, V> bucket : table) {
            if (bucket != null) {
                for (Node<K, V> temp = bucket; temp != null; temp = temp.getNext()) {
                    if (temp.getKey() == null) {
                        index = 0;
                    } else {
                        index = findIndex(temp.getKey(), newCapacity);
                    }
                    if (newTable[index] == null) {
                        newTable[index] = temp;
                    } else {
                        Node<K, V> current = newTable[index];
                        while (current.getNext() != null) {
                            current = current.getNext();

                        }
                        current.setNext(temp);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "table=" + Arrays.toString(table) +
                ", size=" + size +
                '}';
    }
}

