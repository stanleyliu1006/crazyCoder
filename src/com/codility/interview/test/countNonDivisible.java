package com.codility.interview.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class countNonDivisible {

    public static void main(String[] args) {
        int[] A = {3,1,2,3,6};
        System.out.println("count non divisible "+ Arrays.toString(solution(A)));
    }

    public static int[] solution(int[] A) {
        // Implement your solution here
        int[] result = new int[A.length];

        Map<Integer, Integer> freeMap = new HashMap<>();
        for(int i=0; i<A.length; i++){
            freeMap.put(A[i], freeMap.getOrDefault(A[i], 0)+1);
        }

        for(int i=0; i<A.length;i++){
            int num = A[i];
            int nonDivisors =0;

            for(int j=1; j * j<=num; j++){
                if(num%j ==0){
                    if(freeMap.containsKey(j)){
                        nonDivisors += freeMap.get(j);
                    }

                    int complement = num/j;
                    if(j!=complement && freeMap.containsKey(complement)){
                        nonDivisors += freeMap.get(complement);
                    }
                }
            }
            result[i] = A.length - nonDivisors;
        }
        return result;
    }
}
