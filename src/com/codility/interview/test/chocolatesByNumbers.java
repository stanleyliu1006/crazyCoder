package com.codility.interview.test;

public class chocolatesByNumbers {

    public static void main(String[] args) {
        System.out.println("choclate by numbers "+solution(10,4));
    }

    public static int solution(int N, int M) {
        // Implement your solution here
        int lcm = N / gcd(N, M);
        return lcm;
    }

    public static int gcd(int a, int b) {
        if(a % b == 0) return b;
        return gcd(b,a%b);
    }
}
