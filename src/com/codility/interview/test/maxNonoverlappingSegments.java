package com.codility.interview.test;

public class maxNonoverlappingSegments {
    public static void main(String[] args) {
        int[] A = {1,3,7,9,9};
        int[] B = {5,6,8,9,10};
        System.out.println("non overlapping segments "+solution(A,B));
    }
    public static int solution(int[] A, int[] B) {
        // Implement your solution here
        int N = A.length;
        if (N <= 1) {
            return N;
        }

        int count = 1;
        int prev_end = B[0];

        int curr;
        for (curr = 1; curr < N; curr++) {
            if (A[curr] > prev_end) {
                count++;
                prev_end = B[curr];
            }
        }

        return count;
    }
}
