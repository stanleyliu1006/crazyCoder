package com.leetcode.interview.test;

import java.util.LinkedList;
import java.util.List;

public class findMaxSumConArray {

    public static void main(String[] args) {
        double[] input = initialData();
        System.out.println("Maxiumum contignous sum is " + findMaxSum(input));
    }

    private static double findMaxSum(double[] testNumber) {
        double maxSoFar = testNumber[0];
        double curreMax = testNumber[0];

        for(int i=1; i < testNumber.length; i++) {
            curreMax = Math.max(testNumber[i], curreMax + testNumber[i]);
            maxSoFar = Math.max(maxSoFar, curreMax);
        }
        return maxSoFar;
    }

    private static double[] initialData() {
        List<transaction> transactionList = new LinkedList<>();
        transactionList.add(new transaction(1, "d", -10.00));
        transactionList.add(new transaction(2, "c", 3.00));
        transactionList.add(new transaction(3, "d", -4.00));
        transactionList.add(new transaction(4, "c", 5.00));
        transactionList.add(new transaction(5, "c", 9.00));
        return transactionList.stream().mapToDouble(tran->tran.getAmount()).toArray();
    }


}
