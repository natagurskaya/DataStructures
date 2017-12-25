package ua.dp.gurskaya.datastuctures.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStackTest {

    private Stack<String> stack = getStack();
    abstract Stack<String> getStack();

    @Test
    public void testPush() throws Exception {
        stack.push("one");
        stack.push("two");
        stack.push("three");
        assertEquals("one", stack.pop());
        assertEquals("two", stack.pop());
        assertEquals("three", stack.pop());
    }
    @Test
    public void testResize() throws Exception {
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");
        assertEquals(4, stack.size());
    }
    @Test
    public void testSize() throws Exception {
        assertEquals(0, stack.size());
        stack.push("one");
        stack.push("two");
        assertEquals(2, stack.size());
        stack.push("three");
        stack.push("four");
        stack.pop();
        stack.pop();
        assertEquals(2, stack.size());

    }

}
