package com.codility.interview.test;
// you can also use imports, for example:
import java.util.*;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class findMinValFromList {

    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};
        System.out.println("Minum value "+solution(A));
    }
    public static int solution(int[] A) {
        // Implement your solution here
        if (A == null || A.length ==0) {
            return 1;
        }
        Arrays.sort(A);
        int minValue = 1;
        for (int i =0; i<A.length; i++) {
            if(A[i] == minValue){
                minValue++;
            }
        }
        return minValue;
    }
}
