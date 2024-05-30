package com.codility.interview.test;

public class binaryGap {
    public static void main(String[] args) {
        int A = 529;
        System.out.println("Minum value "+solution(A));
    }

    public static int solution(int N) {
        // Implement your solution here
        String binaryString = Integer.toBinaryString(N);

        int currentGap = 0;
        int maxGap = 0;

        for(char c : binaryString.toCharArray()){
            if(c=='0'){
                currentGap++;
            } else if (c == '1'){
                if(currentGap > maxGap){
                    maxGap = currentGap;
                }
                currentGap = 0;
            }
        }
        return maxGap;
    }
}
