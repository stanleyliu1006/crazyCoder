package com.nab.internal.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Timestamp {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse("2023-04-26 11:37:55");
        long timestamp = date.getTime();
        System.out.println("test num "+timestamp/1000);
    }
}
