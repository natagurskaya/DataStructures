package ua.dp.gurskaya.stack;

public class LinkedStackTest extends AbstractStackTest{


    @Override
    Stack getStack() {
        return new LinkedStack();
    }
}