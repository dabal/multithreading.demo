package pl.multithreading.demo;

import pl.multithreading.datastucture.MyOwnBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Magazine {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new MyOwnBlockingQueue(10);
//        BlockingQueue<String> queue = new ArrayBlockingQueue(10);
//        Queue<String> queue=new ArrayDeque<>(10);
        int numbersOfThreads = 5;
        int numbersOfConsumers = 3;
        int numbersOfProducers = numbersOfThreads - numbersOfConsumers;
        int sleepTime = 1000;
        System.out.println("Threads: " + numbersOfThreads);
        System.out.println("Consumers: " + numbersOfConsumers);
        System.out.println("Producers: " + numbersOfProducers);
        ExecutorService pool = Executors.newFixedThreadPool(numbersOfThreads);
        for (int i = 0; i < numbersOfProducers; i++) {
            pool.submit(new Producer(queue, sleepTime, "producer-" + Integer.toString(i)));
        }

        for (int j = 0; j < numbersOfConsumers; j++) {
            pool.submit(new Consumer(queue, sleepTime, "consumer-" + Integer.toString(j)));
        }
        pool.shutdown();
        pool.awaitTermination(30, TimeUnit.SECONDS);
    }
}
