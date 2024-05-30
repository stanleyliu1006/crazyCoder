package com.codility.interview.test;

public class arrListLen {
    public static void main(String[] args) {
        int[] A = {1,4,-1,3,2};
        System.out.println("Minum value "+solution(A));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        int length = 1;
        int i =0;
        while(i<A.length && A[i] !=-1){
            length++;
            i = A[i];
        }
        return length;

    }
}
