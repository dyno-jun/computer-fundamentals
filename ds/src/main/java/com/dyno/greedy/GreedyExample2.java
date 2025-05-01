package com.dyno.greedy;

import java.util.Arrays;

//Given an integer array nums and an integer k, split nums into subsequences,
//where each subsequences' maximum and minimum element is within k of each other.
//What is the minimum number of subsequences needed?
//For example, given nums = [3, 6, 1, 2, 5] and k = 2, the answer is 2. The subsequences are [3, 1, 2] and [6, 5].

public class GreedyExample2 {
  public static void main(String[] args) {
    int[] nums = {3, 6, 1, 2, 5};
    int k = 2;

    int result = getMinimumSubSeq(nums, k);
    System.out.println(result);
  }

  private static int getMinimumSubSeq(int[] nums, int k) {
    Arrays.sort(nums);

    return 2;
  }
}
