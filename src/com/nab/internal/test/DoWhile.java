package com.nab.internal.test;

import java.text.ParseException;

public class DoWhile {
    public static void main(String[] args) throws ParseException {
        int i = 0;
        do {
            System.out.println("get in do while");
            if(i == 3){
                System.out.println("get in 3");
                i = i +3;
                continue;
            }
            i++;
        } while (i<=5);
    }
}
