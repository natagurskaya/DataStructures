package ua.dp.gurskaya.datastuctures.stack;

public class LinkedStackTest extends AbstractStackTest{


    @Override
    Stack<String> getStack() {
        return new LinkedStack<>();
    }
}