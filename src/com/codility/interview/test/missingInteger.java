package com.codility.interview.test;

public class missingInteger {
    public static void main(String[] args) {
        int[] A = {1, 3,6,4,1,2};
        System.out.println("Missing element is "+solution(A));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        int n= A.length;
        boolean[] seen = new boolean[n+1];
        for(int i=0;i<n;i++){
            if(A[i] > 0&& A[i]<=n){
                seen[A[i]] =true;
            }
        }
        for(int i=1;i<=n;i++){
            if(!seen[i]){
                return i;
            }
        }
        return n+1;
    }
    }
