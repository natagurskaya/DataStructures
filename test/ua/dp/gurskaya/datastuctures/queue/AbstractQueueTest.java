package ua.dp.gurskaya.datastuctures.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class AbstractQueueTest {

    private Queue<String> queue = getQueue();
    abstract Queue<String> getQueue();

    @Test
    public void testPushPop() {
        queue.push("one");
        queue.push("two");
        queue.push("three");
        assertEquals("one", queue.pop());
        assertEquals("two", queue.pop());
        assertEquals("three", queue.pop());
    }

    @Test
    public void testResize() {
        queue.push("one");
        queue.push("two");
        queue.push("three");
        queue.push("four");
        assertEquals(4, queue.size());
    }

    @Test
    public void testSize() {
        assertEquals(0, queue.size());
        queue.push("two");
        queue.push("seven");
        assertEquals(2, queue.size());
        queue.pop();
        assertEquals(1, queue.size());
    }
}
