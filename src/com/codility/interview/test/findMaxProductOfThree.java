package com.codility.interview.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class findMaxProductOfThree {

    public static void main(String[] args) {
        int[] A = {-3,1,2,-2,5,6};
        System.out.println("Max Product of three value "+solution(A));
    }

    public static int solution(int[] A) {
        if(A.length<3){
            return 0;
        }
        Arrays.sort(A);
        int size = A.length;
        int maxProduct =A[size-1] * A[size - 2] * A[size -3];
        if(A[0]<0 && A[1]<0){
            int product = A[0] *A[1]*A[size-1];
            maxProduct = Math.max(maxProduct, product);
        }
        return maxProduct;
    }
}
