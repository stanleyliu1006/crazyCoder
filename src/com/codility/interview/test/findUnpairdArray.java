package com.codility.interview.test;

public class findUnpairdArray {

    public static void main(String[] args) {
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        System.out.println("Minum value "+solution(A));
    }

    public static int solution(int[] A) {
        int unpaired =0;
        for(int i=0; i< A.length; i++){
            unpaired = unpaired ^ A[i];
        }
        return unpaired;
    }
}
