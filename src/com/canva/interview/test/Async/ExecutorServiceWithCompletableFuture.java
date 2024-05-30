package com.canva.interview.test.Async;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceWithCompletableFuture {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Integer> itemToProcess = new LinkedList<>();
        for(int i=1; i<=10; i++){
            itemToProcess.add(i);
        }

        List<CompletableFuture> futureList = new LinkedList<>();
        for(Integer item: itemToProcess){
            CompletableFuture<Integer> futureItem = CompletableFuture.supplyAsync(() -> {
                return processItems(item);
            }, executor);
            futureList.add(futureItem);
            futureItem.thenAccept(result->{
                System.out.println("Transform result " + result);
                try {
                    Thread.sleep(1000);
                } catch (Exception e ){
                    e.printStackTrace();
                }
            });
        }

        System.out.println("This is main thread, no wait on the async process thread");
        // Wait for all completableFuture instances complete
        try {
            CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).get();
            System.out.println("This is wait thread, wait all future complete run");
        } catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
        executor.shutdown();
    }

    private static Integer processItems(Integer item) {
        System.out.println("Processing item: " + item);
        return item * (-1);
    }
}
