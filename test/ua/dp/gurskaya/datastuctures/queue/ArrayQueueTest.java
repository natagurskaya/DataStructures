package ua.dp.gurskaya.datastuctures.queue;

public class ArrayQueueTest extends AbstractQueueTest{

    @Override
    Queue getQueue() {
        return new ArrayQueue(3);
    }
}