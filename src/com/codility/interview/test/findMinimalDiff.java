package com.codility.interview.test;

import java.util.Arrays;

public class findMinimalDiff {
    public static void main(String[] args) {
        int[] A = {3,1,2,4,3};
        System.out.println("Minum difference is "+solution(A));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        if (A.length ==2){
            return Math.abs(A[0] - A[1]);
        }
        int[] sum1 = new int[A.length - 1];
        sum1[0] =A[0];
        for(int i=1; i<A.length-1; i++){
            sum1[i] = sum1[i-1] + A[i];
        }
        int[] sum2 = new int[A.length -1];
        sum2[A.length - 2] = A[A.length - 1];
        for(int i=A.length-3;i>=0;i--){
            sum2[i] = sum2[i+1] + A[i+1];
        }
        int finalSum = Integer.MAX_VALUE;
        for(int j=0; j<sum1.length;j++){
            int sum = Math.abs(sum1[j] - sum2[j]);
            if(sum <finalSum){
                finalSum = sum;
            }
        }
        return finalSum;
    }
}
