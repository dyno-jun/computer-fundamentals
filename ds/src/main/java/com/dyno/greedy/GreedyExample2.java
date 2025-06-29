package com.dyno.greedy;

import java.util.Arrays;

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
