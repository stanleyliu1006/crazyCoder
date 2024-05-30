package com.codility.interview.test;

import java.util.Arrays;

public class findTriangle {
    public static void main(String[] args) {
        int[] A = {10,2,5,1,8,20};
        int[] B = {10, 50, 5, 1};
        System.out.println("If there's triangle "+solution(A));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        int n = A.length;
        Arrays.sort(A);
        for(int i =0; i<n-2; i++) {
            if(A[i] + A[i+1] > A[i+2]){
                return 1;
            }
        }
        return 0;
    }
}
