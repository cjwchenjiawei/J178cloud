package com.redis.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class OutThread implements Runnable{
    ArrayBlockingQueue<String> queue = null;
    public OutThread(ArrayBlockingQueue<String> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true){
            try {
                String take = queue.take();
                Thread.sleep(1000*2);
                System.out.println(Thread.currentThread().getName()+"线程取:"+take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
