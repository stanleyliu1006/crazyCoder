package com.leetcode.interview.test;


public class findMinSumConArray {

    public static void main(String[] args) {
        double[] input = {-10.00, 3.00, -4.00, 5.00, 9.00};
        System.out.println("Maxiumum contignous sum is " + findMaxSum(input));
    }

    private static double findMaxSum(double[] testNumber) {
        double minSoFar = testNumber[0];
        double curreMin = testNumber[0];

        for(int i=1; i < testNumber.length; i++) {
            curreMin = Math.min(testNumber[i], curreMin + testNumber[i]);
            minSoFar = Math.min(minSoFar, curreMin);
        }
        return minSoFar;
    }


}
