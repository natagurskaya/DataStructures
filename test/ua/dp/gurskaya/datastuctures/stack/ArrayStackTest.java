package ua.dp.gurskaya.datastuctures.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayStackTest extends AbstractStackTest{

    @Override
    Stack<String> getStack() {
        return new ArrayStack<>(3);
    }
}