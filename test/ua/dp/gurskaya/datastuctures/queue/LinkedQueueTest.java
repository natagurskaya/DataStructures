package ua.dp.gurskaya.datastuctures.queue;

public class LinkedQueueTest extends AbstractQueueTest{


    @Override
    Queue getQueue() {
        return new LinkedQueue();
    }
}