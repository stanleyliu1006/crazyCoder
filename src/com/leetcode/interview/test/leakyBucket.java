package com.leetcode.interview.test;

public class leakyBucket {

  public static void main(String[] args) {
    leakyBucketProcess(6, 10, 5, 2);
  }

  private static void leakyBucketProcess(int no_of_queries, int bucket_size, int input_pkt_size, int output_pkt_size) {
    // initial packets in the bucket
    int storage = 0;
    int size_left;

    for(int i=0; i < no_of_queries; i++) {
      size_left = bucket_size - storage;

      if(input_pkt_size <= size_left){
        storage += input_pkt_size;
      } else {
        System.out.printf("Packet lose = %d \n", input_pkt_size);
      }
      System.out.printf("Buffer size= %d out of total bucket size= %d \n", storage, bucket_size);
      storage -= output_pkt_size;
    }
  }
}
