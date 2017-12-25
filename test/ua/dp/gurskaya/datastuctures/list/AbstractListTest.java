package ua.dp.gurskaya.datastuctures.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class AbstractListTest {

    private List<String> list = getList();
    abstract List<String> getList();

    @org.junit.Test
    public void testAddGet(){
        list.add("1");
        list.add("2");
        list.add("3");
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
    }


    @org.junit.Test
    public void testAddOnIndex(){
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("Hello", 1);
        list.add("Bye", 4);
        assertEquals("1", list.get(0));
        assertEquals("Hello", list.get(1));
        assertEquals("2", list.get(2));
        assertEquals("Bye", list.get(4));
    }

    @org.junit.Test
    public void testRemove(){
        list.add("1");
        list.add("2");
        list.add("3");
        list.remove("1");
        assertEquals("2", list.get(0));
        list.remove("2");
        list.remove("3");
        assertEquals(0, list.size());
    }

    @org.junit.Test
    public void testRemoveByIndex(){
        list.add("one");
        list.add("two");
        list.add("tree");
        list.remove(0);
        assertEquals("two", list.get(0));
        list.remove(1);
        list.remove(0);
        assertEquals(0, list.size());

    }

    @org.junit.Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("Hello");
        assertFalse(list.isEmpty());
    }

    @org.junit.Test
    public void testSize() {
        list.add("Hello");
        assertEquals(1, list.size());
    }

    @org.junit.Test
    public void testSet() {
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.set("Hello", 0);
        assertEquals("Hello", list.get(0));
        list.set("Hello", 4);
        assertEquals("Hello", list.get(4));
    }

    @org.junit.Test
    public void testClear() {
        list.add("111", 0);
        list.add("55", 1);
        list.add("544", 2);
        list.clear();
        assertEquals(0, list.size());
    }

    @org.junit.Test
    public void testIndexOf() {
        list.add("1");
        list.add("2", 1);
        list.add("2", 2);
        list.add("2");
        assertEquals(1, list.indexOf("2"));
    }

    @org.junit.Test
    public void testLastIndexOf() {
        list.add("111", 0);
        list.add("55", 1);
        list.add("544", 2);
        assertEquals(0, list.lastIndexOf("111"));
    }

}
