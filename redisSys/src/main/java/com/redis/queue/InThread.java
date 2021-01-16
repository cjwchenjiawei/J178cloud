package com.redis.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class InThread extends Thread{
    ArrayBlockingQueue<String> queue = null;
    public InThread(ArrayBlockingQueue<String> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        int i = 0;
        while(true){
            try {
                Thread.sleep(1000*5);
                queue.put(Thread.currentThread().getName()+"线程放"+i);
                System.out.println(Thread.currentThread().getName()+"放"+i);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
