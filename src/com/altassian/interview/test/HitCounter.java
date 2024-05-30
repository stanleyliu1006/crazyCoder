package com.altassian.interview.test;

import java.util.logging.Logger;

public class HitCounter {

    private static final Logger logger = Logger.getLogger(HitCounter.class.getName());
    private final int WINDOW_SIZE = 300;

    private int[] hits;
    private int[] timestamps;

    public HitCounter() {
        hits = new int[WINDOW_SIZE];
        timestamps = new int[WINDOW_SIZE];
    }

    public void hit(int timestamp) {
        int index = timestamp % WINDOW_SIZE; //% modulo, index is reminder
        /* If the timestamp at that index is different from the current timestamp,
           it means there were no hits at that timestamp before,
           so it sets the timestamp and hit count to 1.
        */
        if(timestamps[index] != timestamp) {
            timestamps[index] = timestamp;
            hits[index] = 1;
        } else {
        /* If the timestamp matches the current timestamp,
           it means there was already a hit at that timestamp,
           so it increments the hit count.
         */
            hits[index]++;
        }
    }

    public int getHits(int timestamp) {
        int count =0;
        /* It iterates over the timestamps array and checks if
           the difference between the given timestamp and the timestamp stored in the array at each index
           is less than WINDOW_SIZE. If it is, it adds the corresponding hit count to the total count.
           If it equals 300, then its reach to 5 mins can skip that record (like 301 -1)
           This operation has O(1) time complexity because the loop iterates over a fixed-size array.
         */
        for(int i =0; i<WINDOW_SIZE; i++){
            if(timestamp - timestamps[i] < WINDOW_SIZE) {
                count += hits[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        testTotalHitTimes();
    }

    private static void testTotalHitTimes() {
        HitCounter counter = new HitCounter();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        counter.hit(3);
        logger.info(String.valueOf(counter.getHits(4) == 4));

        counter.hit(300);
        counter.hit(301);
        logger.info(String.valueOf(counter.getHits(300) == 5));
        logger.info(String.valueOf(counter.getHits(301) == 5));
        logger.info(String.valueOf(counter.getHits(302) == 4));
        logger.info(String.valueOf(counter.getHits(303) == 2));
    }
}
