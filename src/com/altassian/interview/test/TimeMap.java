package com.altassian.interview.test;

import java.util.*;
import java.util.logging.Logger;

public class TimeMap { //not use TreeMap

    private static final Logger logger = Logger.getLogger(TimeMap.class.getName());
    private Map<String, List<ValueTimestamp>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) { //O(1)
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>()); //use List to store ValueTimestamp object
        }

        List<ValueTimestamp> values = timeMap.get(key); //get empty list

        // Check if the list is empty or if the current timestamp is greater than the latest timestamp
        if (values.isEmpty() || timestamp >= values.get(values.size() - 1).timestamp) {
            values.add(new ValueTimestamp(value, timestamp)); //If yes, add object to the list
        }
    }

    public String get(String key, int timestamp) { // O(log n) for Binary Search
        if (!timeMap.containsKey(key)) {
            return "";
        }

        List<ValueTimestamp> values = timeMap.get(key);
        // Perform binary search to find the largest timestamp less than or equal to the given timestamp
        int index = binarySearch(values, timestamp);

        if (index == -1) {
            return "";
        } else {
            return values.get(index).value;
        }

        // Iterate from the latest value to find the most recent value that fits the condition O(n)
//        for (int i = values.size() - 1; i >= 0; i--) {
//            if (timestamp >= values.get(i).timestamp) { //if passed in timestamp equal greater than the stored value, return the value
//                return values.get(i).value;
//            }
//        }
//
//        return "";
    }

    private int binarySearch(List<ValueTimestamp> values, int timestamp) {  // Further analysis
        int left = 0;
        int right = values.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midTimestamp = values.get(mid).timestamp;

            if (midTimestamp == timestamp) {
                return mid;
            } else if (midTimestamp < timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // At this point, 'left' is the index of the largest timestamp less than the target
        if (left == 0) {
            return -1;
        } else {
            return left - 1;
        }
    }

    private static class ValueTimestamp {
        private String value;
        private int timestamp;

        public ValueTimestamp(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        timeMap.set("foo", "bar2", 2);
        logger.info(String.valueOf(timeMap.get("foo", 1) == "bar"));
        logger.info(String.valueOf(timeMap.get("foo", 2) == "bar2"));
        timeMap.set("foo", "bar3", 4);
        logger.info(String.valueOf(timeMap.get("foo", 4) == "bar3"));
        logger.info(String.valueOf(timeMap.get("foo", 5) == "bar3"));
        logger.info(String.valueOf(timeMap.get("foo", 3) == "bar2"));
        logger.info(String.valueOf(timeMap.get("foo2", 1) == ""));
    }
}


/*
HashMap provides better performance does not maintain the order, Allow null keys O(1)
TreeMap maintains order at the expense slightly slower performance and does not allow null keys O(log n)
 */
class TimeTreeMap {

    private static final Logger logger = Logger.getLogger(TimeTreeMap.class.getName());
    private HashMap<String, TreeMap<Integer, String>> timeMap;

    public TimeTreeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {  //overall will be O(log n)
        /* because it involves searching for the correct position to insert the new entry in the tree,
         and the height of the tree is logarithmic with respect to the number of nodes.
         */

        if(!timeMap.containsKey(key)) {
            timeMap.put(key, new TreeMap<>());
        }
        timeMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) { //overall will be O(log n)
        if(!timeMap.containsKey(key)) {
            return ""; //no key found
        }
        TreeMap<Integer, String> mapValue = timeMap.get(key); //O(1)
        /* It finds the nearest timestamp less than or equal to the specified
         timestamp using floorKey method of TreeMap.
         */
        Integer floorKey = mapValue.floorKey(timestamp); //O(log n) searching for the floor key in the TreeMap
        if(floorKey == null) {
            return ""; //no key found
        }
        return mapValue.get(floorKey);
    }

    public static void main(String[] args) {
        TimeTreeMap timeMap = new TimeTreeMap();
        timeMap.set("foo", "bar", 1);
        logger.info(String.valueOf(timeMap.get("foo", 1) == "bar"));
        logger.info(String.valueOf(timeMap.get("foo", 3) == "bar"));
        timeMap.set("foo", "bar2", 4);
        logger.info(String.valueOf(timeMap.get("foo", 4) == "bar2"));
        logger.info(String.valueOf(timeMap.get("foo", 5) == "bar2"));
        logger.info(String.valueOf(timeMap.get("foo", 3) == "bar"));
        logger.info(String.valueOf(timeMap.get("foo2", 1) == ""));
    }
}

