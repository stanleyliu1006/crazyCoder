package com.codility.interview.test;

import java.util.HashSet;
import java.util.Set;

public class findDistinctValueInArray {

    public static void main(String[] args) {
        int[] A = {2,1,1,2,3,1};
        System.out.println("Distinct value "+solution(A));
    }

    public static int solution(int[] A) {
        Set<Integer> distinctSet = new HashSet<>();
        for(int i=0; i<A.length; i++){
            distinctSet.add(A[i]);
        }
        return distinctSet.size();
    }
}
