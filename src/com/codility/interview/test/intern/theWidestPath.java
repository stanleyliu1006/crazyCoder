package com.codility.interview.test.intern;

import java.util.Arrays;
import java.util.SortedMap;

public class theWidestPath {
    public static void main(String[] args) {
        int X[] = {4, 1, 5, 4};
        int Y[] = {4, 5, 1, 3};
        System.out.println("the widest path "+ solution(X,Y));
    }

    public static int solution(int[] X, int[] Y) {
        //0. If x is empty or contains 1 element, return 0
        if (X.length <= 1){
            return 0;
        }
        //1. sort x in ascending order
        Arrays.sort(X);
        int width = 0;
        //2. Loop x array
        for (int i=1;i<=X.length-1;i++){
            //3. Calculate path width by substraction
            int current =  X[i] - X[i-1];
            //4. Find a maximum value
            width = Math.max(width,current);
        }

        //5. Return maximum value
        return  width;
    }
}
