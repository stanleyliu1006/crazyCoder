package com.leetcode.interview.test;


public class findSumOfPrime {

    public static void main(String[] args) {
        outputSumPrime(5);
    }

    private static void outputSumPrime(int testNumber) {
        for(int i = 2; i <= testNumber/2; i++){
            if(isPrime(i)){
                if(isPrime(testNumber - i)){
                    System.out.printf("%d = %d + %d\n", testNumber, i, testNumber-i);
                }
            }
        }
    }

    private static boolean isPrime(int inputNumber) {
        if(inputNumber < 2) {
            return false;
        }
        boolean isPrime = true;
        for(int i = 2; i <= inputNumber/2; i++) {
            if(inputNumber % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
