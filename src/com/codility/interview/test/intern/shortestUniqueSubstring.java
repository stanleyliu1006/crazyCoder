package com.codility.interview.test.intern;

import java.util.*;

public class shortestUniqueSubstring {
    public static void main(String[] args) {
        String test = "aabbbabaaa";
        System.out.println("substring length is "+ solution(test));
    }

    public static int solution(String input) {
        //Initial store all occurrences list
        List<String> allOccurenceList = new LinkedList<>();

        //Generate all substrings
        for(int i =0; i<input.length(); i++){
            for(int j=i+1; j<=input.length(); j++){
                allOccurenceList.add(input.substring(i, j));
            }
        }

        //Count occurrence of substrings
        Map<String, Integer> countSubstring = new HashMap<>();
        for(String substring : allOccurenceList) {
            countSubstring.put(substring, countSubstring.getOrDefault(substring,0) + 1);
        }

        //Iterate all unique subString get min length
        int minLength = Integer.MAX_VALUE;
        for(String substring : countSubstring.keySet()){
            //Check frequence == 1
            if(countSubstring.get(substring) == 1){
                minLength = Math.min(minLength, substring.length());
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
