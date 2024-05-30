package com.canva.interview.test.MultiThreadAndLock;// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SharedBufferQueue {
    private Queue<Integer> buffer = new LinkedList<>();

    private final int capacity =5;

    public void produce() throws InterruptedException {
        int item = 1;
        while(true) {
            synchronized (this) {
                while(buffer.size() == capacity) {
                    System.out.println("Capacity is full, please wait");
                    wait();
                }

                System.out.println("Producing items...");
                buffer.add(item++);
                notify(); //notify consumer that an item is produced
            }
            Thread.sleep(1000); //sleep 1s
        }
    }

    public void consume() throws InterruptedException {
        while(true) {
            synchronized(this) {
                while(buffer.isEmpty()) {
                    System.out.println("Buffer is empty, producer pls add more items, consumer is waiting...");
                    wait();
                }

                int item = buffer.poll();
                System.out.println("Consuming: "+item);
                notify(); //notify producer an item is consumed, can add more items
            }
            Thread.sleep(1000); //sleep 1s
        }
    }
}

public class RunSynchornizedQueue {
    public static void main(String[] args) {
        SharedBufferQueue sharedResource = new SharedBufferQueue();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable producer = () -> {
            try {
                sharedResource.produce();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable consumer = () -> {
            try {
                sharedResource.consume();
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        };

        executor.submit(producer);
        executor.submit(consumer);

        executor.shutdown();

    }
}