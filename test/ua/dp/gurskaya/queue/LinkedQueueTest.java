package ua.dp.gurskaya.queue;

public class LinkedQueueTest extends AbstractQueueTest{


    @Override
    Queue getQueue() {
        return new LinkedQueue();
    }
}