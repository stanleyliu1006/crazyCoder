package com.canva.interview.test.MultiThreadAndLock;// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SharedResource {
    private boolean conditionMet = false;

    public synchronized void waitForCondition() throws InterruptedException {
        while(!conditionMet) {
            System.out.println("Condition not met, and wait...");
            wait();
        }
        System.out.println("Codition met. Continuing...");
    }

    public synchronized void setConditionMet() throws InterruptedException {
        conditionMet = true;
        System.out.println("Met condition, and notify producer thread");
        notify();
    }
}
public class RunSynchronized {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable producer = () -> {
            try {
                Thread.sleep(1000);
                sharedResource.setConditionMet();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable consumer = () -> {
            try {
                sharedResource.waitForCondition();
                System.out.println("Completed Consume task executed.");
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        };

        executor.submit(producer);
        executor.submit(consumer);

        executor.shutdown();

    }
}