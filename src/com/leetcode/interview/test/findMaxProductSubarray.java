package com.leetcode.interview.test;

public class findMaxProductSubarray {  //TimeComplexity O(n), SpaceComplexity O(1)

    public static void main(String[] args) {
        int[] testArray = new int[]{ 1,2,0,4,5,-3};
        System.out.printf("The max product of subarray is = %d", maxProductOfSubarray(testArray));
    }

    private static int maxProductOfSubarray(int[] numArray) {
        int product_max = numArray[0];
        int product_min = numArray[0];
        int overall_max = numArray[0];

        for(int i =0;i<numArray.length;i++){
            if(numArray[i] < 0) { // checking if negative value
                int temp = product_max;
                product_max = product_min;
                product_min = temp;
            }
            product_max = Math.max(numArray[i], numArray[i] * product_max);
            product_min = Math.min(numArray[i], numArray[i] * product_min);
            overall_max = Math.max(overall_max, product_max);
        }
        return overall_max;
    }
}
