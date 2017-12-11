package ua.dp.gurskaya.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class AbstractQueueTest {

    private Queue queue = getQueue();
    abstract Queue getQueue();

    @Test
    public void testPushPop() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertEquals(1, queue.pop());
        assertEquals(2, queue.pop());
        assertEquals(3, queue.pop());
    }

    @Test
    public void testResize() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        assertEquals(4, queue.size());
    }

    @Test
    public void testSize() {
        assertEquals(0, queue.size());
        queue.push(2);
        queue.push(7);
        assertEquals(2, queue.size());
        queue.pop();
        assertEquals(1, queue.size());
    }
}
