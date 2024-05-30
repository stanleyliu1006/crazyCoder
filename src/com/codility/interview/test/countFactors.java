package com.codility.interview.test;

public class countFactors {
    public static void main(String[] args) {
        System.out.println("count factors "+solution(6));
    }

    public static int solution(int N) {
        // Implement your solution here
        int result = 0;
        for (int i=1; i<=(double)Math.sqrt(N); i++) {
            if(i==(double)Math.sqrt(N)) {
                result++;
            }else if(N % i == 0) {
                result = result + 2;
            }
        }
        return result;
    }
}
