package pl.multithreading.demo;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

    private final BlockingQueue<String> queue;
    private int sleepTime;
    private final String name;
    public static AtomicInteger size=new AtomicInteger(0);

    public Producer(BlockingQueue<String> queue, int sleepTime, String name) {
        if (queue == null) {
            throw new IllegalArgumentException("Queue cannot be null.");
        }
        if (sleepTime < 0) {
            throw new IllegalArgumentException("Sleep time cannot be lower than 0.");
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
                String uid = UUID.randomUUID().toString();
                queue.put(uid);

//                System.out.println(size.incrementAndGet()+" " +queue.size());
                System.out.println(name + " - putting - " + uid+" - "+ queue.toString());

                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
