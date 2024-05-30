package com.codility.interview.test;

public class strSymmetryPoint {
    public static void main(String[] args) {
        System.out.println("symetry point "+solution("a"));
    }

    public static int solution(String S){
        // Implement your solution here
        if (S.length()==0 || S.length()%2==0){
            return -1;
        }
        int result = S.length() / 2;
        for (int i = result, j = result; j >= 0; i++, j--) {
            if (S.charAt(i) != S.charAt(j)) {
                return -1;
            }
        }
        return result;
    }
}
