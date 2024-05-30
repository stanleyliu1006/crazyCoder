package com.codility.interview.test;

public class maxProfit {
    public static void main(String[] args) {
        int[] A = {23171,21011,21123,21366,21013,21367};
        System.out.println("Max profit "+solution(A));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;

        for(int i=0; i<A.length; i++){
            if(A[i] <minPrice){
                minPrice = A[i];
            } else if(A[i] - minPrice >maxProfit){
                maxProfit = A[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
