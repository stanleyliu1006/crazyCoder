package com.codility.interview.test;

import java.util.Arrays;

public class cyclicRotationArray {

    public static void main(String[] args) {
        int[] A = {3, 8, 9, 7, 6};
        int K = 3;
        System.out.println("Rotated array is "+ Arrays.toString(solution(A, K)));
    }

    public static int[] solution(int[] A, int K) {
        int[] result = new int[A.length];
        for(int i =0; i< A.length; i++){
            result[(i+K) % A.length] = A[i];
        }
        return result;
    }
}
