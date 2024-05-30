package com.codility.interview.test;

public class numberSolitaire {
    public static void main(String[] args) {
        int[] A = {1,-2,0,9,-1,-2};
        System.out.println("number solitaire "+solution(A));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        int n = A.length;
        int[] dynamicSum = new int[n];
        dynamicSum[0] = A[0];
        int maxCurrent;
        for (int i = 1; i < n; i++) {
            maxCurrent = dynamicSum[i-1];
            for (int j = 1; j <= 6; j++)
                if (i - j >= 0) {
                    maxCurrent = Math.max(dynamicSum[i - j], maxCurrent);
                }
            dynamicSum[i] = maxCurrent + A[i];
        }
        return dynamicSum[n-1];
    }
}