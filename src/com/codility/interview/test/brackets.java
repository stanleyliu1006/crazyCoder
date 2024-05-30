package com.codility.interview.test;

import java.util.Stack;

public class brackets {
    public static void main(String[] args) {
        String S = "{[()()]}";
        System.out.println("If there's a perm "+solution(S));
    }

    public static int solution(String S) {
        // Implement your solution here
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<S.length(); i++){
            char c= S.charAt(i);
            if(c =='(' || c=='[' || c=='{'){
                stack.push(c);
            } else {
                if(stack.empty()){
                    return 0;
                }
                char top = stack.pop();
                if((c==')' && top!='(') ||
                    (c==']' && top!='[')||
                    (c=='}' && top!='{')){
                    return 0;
                }
            }
        }
        return stack.empty() ? 1 : 0;
    }
}
