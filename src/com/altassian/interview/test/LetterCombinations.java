package com.altassian.interview.test;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Logger;

public class LetterCombinations { //Patience Sorting algorithm or LIS algorithm

    private static final Logger logger = Logger.getLogger(LetterCombinations.class.getName());

    private static String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    //Time Complexity O(nlog(n)
    //Space Complexity O(n) TreeSet
    public List<String> combinations(String digits){
        LinkedList<String> outputs = new LinkedList<>();
        if(digits.isEmpty()){
            return outputs;
        }
        outputs.add("");
        for(int i=0; i<digits.length(); i++){
            int idx = Character.getNumericValue(digits.charAt(i));
            while(outputs.peek().length() == i){
                String perm = outputs.remove();
                for(char c : mapping[idx].toCharArray()) {
                    outputs.add(perm + c);
                }
            }
        }
        return outputs;
    }

    public static void main(String[] args) {
        LetterCombinations sub = new LetterCombinations();
        sub.combinations("23").forEach(val -> logger.info(val));
        //logger.info(String.valueOf(sub.lengthOfLongestIncreaseSub(new int[]{10, 9, 2, 5, 3, 7, 101, 18}) == 4));
    }
}
