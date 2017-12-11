package ua.dp.gurskaya.queue;

public class ArrayQueueTest extends AbstractQueueTest{

    @Override
    Queue getQueue() {
        return new ArrayQueue(3);
    }
}