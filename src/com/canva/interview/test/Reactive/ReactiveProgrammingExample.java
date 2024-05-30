//package com.canva.interview.test.Reactive;
//
//import reactor.core.publisher.Flux;
//
//public class ReactiveProgrammingExample {
//    public static void main(String[] args) {
//        // Create a Flux (reactive stream) of integers
//        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5);
//
//        // Transform and process the elements in the Flux
//        flux
//                .map(number -> number * 2) // Double each element
//                .filter(number -> number % 4 == 0) // Filter for even numbers
//                .subscribe(
//                        result -> System.out.println("Received: " + result), // Subscribe to the stream
//                        error -> System.err.println("Error: " + error), // Handle errors
//                        () -> System.out.println("Stream completed") // Handle completion
//                );
//    }
//}