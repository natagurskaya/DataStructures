package ua.dp.gurskaya.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStackTest {

    private Stack stack = getStack();
    abstract Stack getStack();

    @Test
    public void testPush() throws Exception {
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
    }
    @Test
    public void testResize() throws Exception {
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(4);
        assertEquals(4, stack.size());
    }
    @Test
    public void testSize() throws Exception {
        assertEquals(0, stack.size());
        stack.push(2);
        stack.push(3);
        assertEquals(2, stack.size());
        stack.push(4);
        stack.push(5);
        stack.pop();
        stack.pop();
        assertEquals(2, stack.size());

    }

}
