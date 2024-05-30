package com.codility.interview.test;

import java.util.HashMap;
import java.util.Map;

public class firstUnique {
    public static void main(String[] args) {
        int[] A = {3,2,2,3,1};
        System.out.println("find latest unique val "+solution(A));
    }
    public static int solution(int[] A) {
        // Implement your solution here
        Map<Integer, Integer> frequenceMap = new HashMap<>();
        for(int i=0; i<A.length; i++){
            int num = A[i];
            frequenceMap.put(num,frequenceMap.getOrDefault(num, 0) + 1);
        }
        for(int i=0; i<A.length; i++){
            int num = A[i];
            if(frequenceMap.get(num) == 1){
                return num;
            }
        }
        return -1;
    }
}
