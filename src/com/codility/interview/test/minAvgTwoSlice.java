package com.codility.interview.test;

public class minAvgTwoSlice {
    public static void main(String[] args) {
        int[] A = {4,2,2,5,1,5,8};
        System.out.println("Min positiong "+solution(A));
    }

    public static int solution(int[] A) {
        // Implement your solution here
        int N = A.length;
        int minPos = 0;
        double minAvg = (A[0] + A[1]) /2.0;

        for(int i=0;i<N-1;i++){
            if((double)(A[i] + A[i+1])/2.0<minAvg){
                minAvg = (double)(A[i] + A[i+1])/2.0;
                minPos= i;
            }
            if(i<N-2 && (double)(A[i] + A[i+1] + A[i+2])/3.0<minAvg){
                minAvg = (double)(A[i] + A[i+1]+A[i+2])/3.0;
                minPos= i;
            }
        }
        return minPos;
    }
}
