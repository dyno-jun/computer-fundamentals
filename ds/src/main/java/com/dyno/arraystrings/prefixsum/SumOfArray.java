package com.dyno.arraystrings.prefixsum;

import java.util.Arrays;

public class SumOfArray {

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 4};
    int[] result = new SumOfArray().runningSum(nums);
    System.out.println(Arrays.toString(result));
  }

  public int[] runningSum(int[] nums) {
    int[] results = new int[nums.length];
    results[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      results[i] = results[i - 1] + nums[i];
    }

    return results;
  }
}
