package pl.multithreading.demo;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<String> queue;
    private int sleepTime;
    private final String name;

    public Consumer(BlockingQueue<String> queue, int sleepTime, String name) {
        if (queue == null) {
            throw new IllegalArgumentException("Queue cannot be null.");
        }
        if (sleepTime < 0) {
            throw new IllegalArgumentException("Sleep time cannot be lower than zero.");
        }
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        this.queue = queue;
        this.sleepTime = sleepTime;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(name + " - getting - " + queue.take());
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
