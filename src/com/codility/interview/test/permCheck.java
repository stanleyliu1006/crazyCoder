package com.codility.interview.test;

import java.util.Arrays;

public class permCheck {
    public static void main(String[] args) {
        int[] A = {1,2,3,5,5,5};
        System.out.println("If there's a perm "+solution(A));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        int n=A.length;
        boolean[] perm = new boolean[n+1];
        for(int i=0 ; i<n;i++){
            if(A[i] > n || perm[A[i]]){
                return 0;
            }
            perm[A[i]] = true;
        }
        return 1;
    }
}
