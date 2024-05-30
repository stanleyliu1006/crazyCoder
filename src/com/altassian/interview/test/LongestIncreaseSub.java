package com.altassian.interview.test;

import java.util.TreeSet;
import java.util.logging.Logger;

public class LongestIncreaseSub { //Patience Sorting algorithm or LIS algorithm

    private static final Logger logger = Logger.getLogger(LongestIncreaseSub.class.getName());

    //Time Complexity O(nlog(n)
    //Space Complexity O(n) TreeSet
    public int lengthOfLongestIncreaseSub(int[] nums) {
        TreeSet<Integer> bst = new TreeSet<>();
        for(int num : nums) {
            Integer higherOrEqual = bst.ceiling(num); //least element in the set greater or equal to the given element
            if(higherOrEqual==null){
                bst.add(num);
            } else { //if there's a value, remove the current one from set and add new num to the set
                bst.remove(higherOrEqual);
                bst.add(num);
            }
        }
        return bst.size();
    }

    public static void main(String[] args) {
        LongestIncreaseSub sub = new LongestIncreaseSub();
        logger.info(String.valueOf(sub.lengthOfLongestIncreaseSub(new int[]{10, 9, 2, 5, 3, 7, 101, 18}) == 4));
        logger.info(String.valueOf(sub.lengthOfLongestIncreaseSub(new int[]{0, 1, 0, 3, 2, 3}) == 4));
        logger.info(String.valueOf(sub.lengthOfLongestIncreaseSub(new int[]{7, 7, 7, 7, 7, 7, 7}) == 1));
        logger.info(String.valueOf(sub.lengthOfLongestIncreaseSub(new int[]{4, 10, 4, 3, 8, 9}) == 3));
    }
}
