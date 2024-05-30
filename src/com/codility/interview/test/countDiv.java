package com.codility.interview.test;

public class countDiv {
    public static void main(String[] args) {
        System.out.println("If there's a perm "+solution(6,11,2));
    }

    public static int solution(int A, int B, int K) {
        // Implement your solution here
        int value = (B/K) - (A/K);
        if(A%K==0){
            value+=1;
        }
        return value;
    }
}
