package com.codility.interview.test;

public class ladder {
    public static void main(String[] args) {
        int[] A = {4,4,5,5,1};
        int[] B = {3,2,4,3,1};
        System.out.println("ladder array "+solution(A,B));
    }
    public static int[] solution(int[] A, int[] B) {
        // Implement your solution here
        int L = A.length;
        int[] fib = new int[L+2];
        int[] result = new int[L];
        fib[1] = 1;
        fib[2] = 2;
        for (int i = 3; i <= L; i++) {
            // make sure the fibonacci number will not exceed the max integer in java 1<<n = 2^n
            fib[i] = (fib[i-1] + fib[i-2]) % (1 << 30);
        }
        for (int i = 0; i < L; i++) {
            result[i] = fib[A[i]] % (1 << B[i]);
        }
        return result;
    }
}
