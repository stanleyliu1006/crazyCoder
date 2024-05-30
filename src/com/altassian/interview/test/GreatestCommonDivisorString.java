package com.altassian.interview.test;

import java.util.logging.Logger;

public class GreatestCommonDivisorString {
    private static final Logger logger = Logger.getLogger(GreatestCommonDivisorString.class.getName());
    public static String gcdOfStrings(String str1, String str2) {
        int gcd = getGcd(str1.length(), str2.length());
        String divisor = str1.substring(0, gcd); //creates a substring divisor from beginning of str1
        if(isDivisor(str1, divisor) && isDivisor(str2, divisor)){
            return divisor;
        }
        return "";
    }

    public static boolean isDivisor(String str, String divisor){
        int strLen = str.length();
        int divLen = divisor.length();

        if(strLen % divLen != 0) { // check divisor is dividable or not
            return false;
        }
        for(int i = 0; i<strLen; i+= divLen){ // iterates through str in chunks of size divLen
            if(!str.startsWith(divisor, i)){ // checks if the substring of str starting from index i and of length divLen is equal to divisor
                return false; // if any of these substrings is not equal to divisor
            }
        }
        return true; // if all the substrings are equal to divisor, it means divisor divides str perfectly, and the function returns true.
    }

    public static int getGcd(int a, int b){ //Euclidean algorithm finds the GCD of two numbers
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args){
        String result1 = gcdOfStrings("ABCABC", "ABC");
        String result2 = gcdOfStrings("ABABAB", "ABAB");
        String result3 = gcdOfStrings("LEET", "CODE");

        logger.info(String.valueOf(result1.equals("ABC")));
        logger.info(String.valueOf(result2.equals("AB")));
        logger.info(String.valueOf(result3.equals("")));

    }
}
