package com.leetcode.interview.test;

public class sumDigitsUntilOne { //TimeComplexity O(1), SpaceComplexity O(1)

  public static void main(String[] args) {
    testSumDigitsUnitlOne();
  }

  private static int sumDigitsUntilOne2(int testNumber) {
    if (testNumber == 0) {
      return 0;
    }
    return (testNumber % 9 == 0) ? 9 : (testNumber%9);
  }

  private static void testSumDigitsUnitlOne() {
    System.out.println(assertEqual(sumDigitsUntilOne2(1), 1));
    System.out.println(assertEqual(sumDigitsUntilOne2(49), 4));
    System.out.println(assertEqual(sumDigitsUntilOne2(439230), 3));
  }

  private static boolean assertEqual(int sumDigitsUntilOne, int i) {
    return sumDigitsUntilOne == i;
  }
}
