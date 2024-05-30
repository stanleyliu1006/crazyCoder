package com.codility.interview.test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class absDistinct {
    public static void main(String[] args) {
        int[] A = {-5,-3,-1,0,3,6};
        System.out.println("absDistinct "+ solution2(A));
    }

    public static int solution(int[] A) {
        int arrayLength= A.length;
        int head = 0;
        int tail = arrayLength - 1;
        int result = 1;
        // the current maximal value
        int currMaxValue = Math.max(Math.abs(A[head]), Math.abs(A[tail]));
        // we should be careful of the minimal integer number in JAVA, because
        // the absolute value of it is still a negative number.
        if (A[head] == Integer.MIN_VALUE)
            currMaxValue = Math.abs(A[head]);
        while (head <= tail) {
            int currHead = Math.abs(A[head]);
            // the same value of the current maximal value should not be counted
            if (currHead == currMaxValue) {
                head++;
                continue;
            }
            int currTail = Math.abs(A[tail]);
            // the same value of the current maximal value should not be counted
            if (currTail == currMaxValue) {
                tail--;
                continue;
            }
            // get the new current maximal value
            if (currHead >= currTail) {
                currMaxValue = currHead;
                head++;
            } else {
                currMaxValue = currTail;
                tail--;
            }
            // meet a new distinct absolute value
            result++;
        }
        return result;

    }

    public static int solution2(int[] A) {
        Set<Integer> testSet = new LinkedHashSet<>();
        return (int) Arrays.stream(A).map(val->Math.abs(val)).distinct().count();
    }
}
