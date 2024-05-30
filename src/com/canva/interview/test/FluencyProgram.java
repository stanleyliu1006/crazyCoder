package com.canva.interview.test;

public class FluencyProgram {
    public static void main(String[] args) {
        System.out.println("Reversed string "+reverseString("abc"));
        System.out.println("Factorial number "+factorial(3));
        System.out.println("isPalindrome "+isPalindrome("racecar"));
    }

    private static String reverseString(String value) {
        String result = "";
        for(int i =value.length() -1; i>=0; i--){
            result += value.charAt(i);
        }
        return  result;
    }

    private static int factorial(int n) {
        int result = 1;
        while(n > 0) {
            result *= n;
            n--;
        }
        return result;
    }

    private static boolean isPalindrome(String value) {
        int left = 0;
        int right = value.length() - 1;

        while (left < right) {
            if(value.charAt(left) != value.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }



}
