package com.codility.interview.test.intern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class distinctNumbersCount {
    public static void main(String[] args) {
        int[] A = {10000000, 10000000, 5, 5, 5, 2, 2, 2, 0, 0};
        System.out.println("deletion total number is "+ solution(A));
    }

    public static int solution(int[] A) {
        Map<Integer, Integer> countNum = new HashMap<>();
        Set<Integer> uniqueVal = new HashSet<>();
        int deletion = 0;

        for(int num : A){
            //calculate counts of array element
            countNum.put(num, countNum.getOrDefault(num, 0) + 1);
        }

        for(int count : countNum.values()){
            //remove element until its unique
            while(uniqueVal.contains(count) && count >0){
                deletion++;
                count--;
            }
            uniqueVal.add(count);
        }

        return deletion;
    }
}
