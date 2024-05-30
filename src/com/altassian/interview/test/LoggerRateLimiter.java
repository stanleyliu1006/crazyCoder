package com.altassian.interview.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

public class LoggerRateLimiter { //O(1)

    private static final Logger logger = Logger.getLogger(LoggerRateLimiter.class.getName());

    Map<String, Integer> logs;

    public LoggerRateLimiter() {
        logs = new HashMap<>();
    }

    public boolean shouldPrint(int timestamp, String message) {
        if(logs.containsKey(message)){
            if(timestamp - logs.get(message) >= 10){
                logs.put(message, timestamp);
                return true;
            } else {
                return false;
            }

        } else {
            logs.put(message, timestamp);
            return true;
        }
    }


    public static void main(String[] args) {
        LoggerRateLimiter loggerRate = new LoggerRateLimiter();
        logger.info(String.valueOf(loggerRate.shouldPrint(1, "foo") == true));
        logger.info(String.valueOf(loggerRate.shouldPrint(2, "bar") == true));
        logger.info(String.valueOf(loggerRate.shouldPrint(3, "foo") == false));
        logger.info(String.valueOf(loggerRate.shouldPrint(8, "bar") == false));
        logger.info(String.valueOf(loggerRate.shouldPrint(10, "foo") == false));
        logger.info(String.valueOf(loggerRate.shouldPrint(11, "foo") == true));
    }
}

class LoggerRateLimiterLinkedHashMap { //improve space complexity remains bounded, doesn't grow indefinitely O(1)

    private static final Logger logger = Logger.getLogger(LoggerRateLimiterLinkedHashMap.class.getName());

    Map<String, Integer> logs;

    int lastSec = 0;

    public LoggerRateLimiterLinkedHashMap() {
        logs = new LinkedHashMap<String, Integer>() {
            protected boolean removeEldest(Map.Entry<String, Integer> eldest) {
                return lastSec - eldest.getValue() > 10;
            }
        };
    }

    public boolean shouldPrint(int timestamp, String message) {
        lastSec = timestamp;
        if(!logs.containsKey(message) || timestamp - logs.get(message) >= 10) {
            logs.put(message, timestamp);
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        LoggerRateLimiterLinkedHashMap loggerRate = new LoggerRateLimiterLinkedHashMap();
        logger.info(String.valueOf(loggerRate.shouldPrint(1, "foo") == true));
        logger.info(String.valueOf(loggerRate.shouldPrint(2, "bar") == true));
        logger.info(String.valueOf(loggerRate.shouldPrint(3, "foo") == false));
        logger.info(String.valueOf(loggerRate.shouldPrint(8, "bar") == false));
        logger.info(String.valueOf(loggerRate.shouldPrint(10, "foo") == false));
        logger.info(String.valueOf(loggerRate.shouldPrint(11, "foo") == true));
    }

}