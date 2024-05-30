package com.codility.interview.test;

public class findStepsOfFrogJump {
    public static void main(String[] args) {
        System.out.println("Minum value "+solution(10, 85, 30));
    }

    public static int solution(int X, int Y, int D) {
        // Implement your solution here
        int distnace = Y - X;

        int jumps = distnace / D;

        if(distnace % D != 0) {
            jumps ++;
        }
        return jumps;
    }
}
