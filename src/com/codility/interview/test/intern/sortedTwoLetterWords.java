package com.codility.interview.test.intern;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class sortedTwoLetterWords {
    public static void main(String[] args) {
        String A = "BAAABABAB";
        System.out.println("absDistinct "+ solution(A));
    }

    public static int solution(String S) {
        int B=0;
        int delete=0;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == 'A'){
                delete = Math.min(delete+1, B);
            } else {
                B++;
            }
        }
        return delete;
    }

}
