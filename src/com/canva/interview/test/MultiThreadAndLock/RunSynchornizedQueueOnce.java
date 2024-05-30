package com.canva.interview.test.MultiThreadAndLock;// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SharedBufferQueueOnce {
    private Queue<Integer> buffer = new LinkedList<>();

    private final int capacity =5;

    public void produce() throws InterruptedException {
        while(true) {
            synchronized (this) {
                for(int i=1; i<=capacity; i++) {
                    buffer.add(i);
                    System.out.println("Producer: produced "+i+ " item(s)");
                }
                if(buffer.size() == capacity){
                    notify();
                    wait();
                    System.out.println("Wait consumer to consume "+capacity+" item(s)");
                }
            }
            Thread.sleep(1000); //sleep 1s
        }
    }

    public void consume() throws InterruptedException {
        while(true) {
            synchronized(this) {
                if(buffer.size() != 5) {
                    wait();
                    System.out.println("Wait producer to add 5 new items to the buffer");
                }
                while(!buffer.isEmpty()) {
                    System.out.println("Consumer consume items "+buffer.poll());
                }
                notify(); //notify producer an item is consumed, can add more items
            }
            Thread.sleep(1000); //sleep 1s
        }
    }
}

public class RunSynchornizedQueueOnce {
    public static void main(String[] args) {
        SharedBufferQueueOnce sharedResource = new SharedBufferQueueOnce();
        ExecutorService executor = Executors.newFixedThreadPool(4);

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