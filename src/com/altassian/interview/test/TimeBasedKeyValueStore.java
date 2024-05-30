package com.altassian.interview.test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class TimeBasedKeyValueStore {

    private static final Logger logger = Logger.getLogger(TimeBasedKeyValueStore.class.getName());
    private Map<String, TreeMap<Integer, String>> timeBasedMap;
    public TimeBasedKeyValueStore() {
        timeBasedMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) { //time complexity O(log n)
        timeBasedMap.computeIfAbsent(key, k-> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) { //time complexity O(log n)
        if(!timeBasedMap.containsKey(key)){
            return "";
        }
        TreeMap<Integer, String> timeMap = timeBasedMap.get(key);
        Integer smallTimeStamp = timeMap.floorKey(timestamp);
        return smallTimeStamp == null ? "" : timeMap.get(smallTimeStamp);
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore timeMap = new TimeBasedKeyValueStore();
        timeMap.set("foo", "bar", 1);
        logger.info(String.valueOf(timeMap.get("foo", 1).equalsIgnoreCase("bar")));    // Output: bar
        logger.info(String.valueOf(timeMap.get("foo", 3).equalsIgnoreCase("bar")));    // Output: bar
        timeMap.set("foo", "bar2", 4);
        logger.info(String.valueOf(timeMap.get("foo", 4).equalsIgnoreCase("bar2")));    // Output: bar2
        logger.info(String.valueOf(timeMap.get("foo", 5).equalsIgnoreCase("bar2")));    // Output: bar2
    }
}

