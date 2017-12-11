package ua.dp.gurskaya.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayStackTest extends AbstractStackTest{

    @Override
    Stack getStack() {
        return new ArrayStack(3);
    }
}