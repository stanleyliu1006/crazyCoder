package com.leetcode.interview.test;

public class sumDigitsUntilOneOlogn { //TimeComplexity OlogN
    public static void main(String[] args) {
        System.out.println(findSum(49));
    }

    public static int findSum(int number) {
        int sum = 0;
        while(number >0 || sum >9){
            if(number==0){ //check sum>9 and number =0, clear sum
                number = sum;
                sum=0;
            }
            sum += number%10; //find last digit
            number = number/10; //remove last digit
        }
        return sum;
    }
}
