package com.codility.interview.test;

import java.util.Stack;

public class dominator {
    public static void main(String[] args) {
        int[] A= {3,4,3,2,3,-1,3,3};
        System.out.println("Dominator: "+solution(A));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        int N = A.length;
        int candidate = -1;
        int count =0;
        for(int i=0; i< N; i++){
            if(count==0){
                candidate = i;
                count=1;
            } else {
                if(A[i] == A[candidate]){
                    count++;
                } else {
                    count--;
                }
            }
        }

        int dominator = -1;
        count=0;

        for(int i=0; i<N; i++){
            if(A[i] == A[candidate]){
                count++;
                if(count > N/2){
                    dominator = A[candidate];
                    break;
                }
            }
        }

        if(dominator!=-1){
            for(int i=0; i< N;i++){
                if(A[i] == dominator){
                    return i;
                }
            }
        }
        return -1;
    }
}
