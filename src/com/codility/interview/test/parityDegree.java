package com.codility.interview.test;

public class parityDegree {
    public static void main(String[] args) {
        int T=1;
        System.out.println("parity degree "+solution(24));
    }

    public static int solution(int N) {
        // Implement your solution here
        int highestPower = 0;
        while(N>0 && N%2==0){
            highestPower++;
            N/=2;
        }
        return highestPower;
    }
}
