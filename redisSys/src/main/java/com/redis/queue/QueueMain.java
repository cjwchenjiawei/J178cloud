package com.redis.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class QueueMain {
    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(10);
        InThread inThread1 = new InThread(queue);
        InThread inThread2 = new InThread(queue);
        OutThread outThread1 = new OutThread(queue);
        OutThread outThread2 = new OutThread(queue);

//        inThread1.start();
        inThread2.start();
        new Thread(outThread1).start();
        new Thread(outThread2).start();

    }
}
