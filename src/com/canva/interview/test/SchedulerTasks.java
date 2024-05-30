//package com.canva.interview.test;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.concurrent.*;
//import java.util.stream.Collectors;
//
//public class SchedulerTasks {
//    private static final Object lockDbRead = new Object();
//    private static List<FileMetadata> metaList = new ArrayList<>();
//    private static boolean uploadDoneSignal = false;
//
//    public static void main(String[] args) {
//        //Start a scheduler tasks to pull image records from db
//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
//
//        //Multi-threads to upload file to storage S3 etc, but only one thread read table records a time
//        Runnable schedulTask = () -> {
//            performReadDbTask();
//            performUploadTask();
//        };
//        ScheduledFuture<?> taskCycle = scheduler.scheduleAtFixedRate(schedulTask, 0, 1, TimeUnit.SECONDS);
//
//        //Once all upload call finish Close multi threads, shutdown scheduler
//        if(taskCycle.isDone()) {
//            scheduler.shutdown();
//        }
//    }
//
//    private static void performReadDbTask() {
//        try {
//            synchronized(lockDbRead) {
//                //critical part is read from db, only allow one thread
//                metaList = readFromDb();
//                System.out.println("Read records from db is finished, can release lock now");
//                lockDbRead.notify();
//            }
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    private static void performUploadTask() {
//        try {
//            synchronized(lockDbRead) {
//                while(metaList.isEmpty()){
//                    lockDbRead.wait();
//                    System.out.println("Wait read db task finished to release the lock");
//                }
//            }
//            uploadFileToS3(metaList);
//            if(uploadDoneSignal){
//                System.out.println("This thread of batch upload is done");
//            }
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    private static void uploadFileToS3(List<FileMetadata> metaList) {
//        //Upload file use aync completeFuture
//        ExecutorService executor = Executors.newFixedThreadPool(5);
//        S3Client client = new S3Client();
//        List<CompletableFuture> futureList = new LinkedList<>();
//        for(FileMetadata itemImage: metaList){
//            CompletableFuture<String> futureItem = CompletableFuture.supplyAsync(() -> {
//                return client.putObject(meta.key, meta.name);
//            }, executor);
//            futureList.add(futureItem);
//        }
//        try {
//            CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).get();
//            uploadDoneSignal = true;
//            System.out.println("This is wait thread, wait all future complete run");
//        } catch (InterruptedException | ExecutionException e){
//            e.printStackTrace();
//        }
//    }
//
//    private static List<FileMetadata> readFromDb() {
//        return null;
//    }
//
//
//}
