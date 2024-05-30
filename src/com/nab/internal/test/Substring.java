package com.nab.internal.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Substring {
    public static void main(String[] args) throws ParseException {
        String test = "1";
        char test1 = Character.toTitleCase(test.charAt(0));
        String test2 = test1 + test.substring(1);
        try {
            System.out.println("test num " + test2.equals("1"));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("test num error " + e.getMessage());
        }
    }
}
