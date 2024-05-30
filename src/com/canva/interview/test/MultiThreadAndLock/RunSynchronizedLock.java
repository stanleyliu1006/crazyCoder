package com.canva.interview.test.MultiThreadAndLock;// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunSynchronizedLock {
    private static boolean lockCondition = false;
    private static final Object lockObj = new Object();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Runnable concurrentTask = () -> {
            performConcurrentTask();
        };
        executor.submit(concurrentTask);
        processMain();
        executor.shutdown();
    }

    private static void performConcurrentTask() {
        try {
            Thread.sleep(2000);
            synchronized (lockObj) {
                System.out.println("concurrent task starts");
                lockCondition = true;
                lockObj.notify();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void processMain() {
        synchronized (lockObj) {
            while (!lockCondition) {
                try {
                    lockObj.wait();
                    System.out.println("Main thread Wait ...");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println("Main Task is completed now!");
    }
}