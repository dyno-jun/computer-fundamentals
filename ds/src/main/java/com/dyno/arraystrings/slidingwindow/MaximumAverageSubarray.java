package com.dyno.arraystrings.slidingwindow;

// You are given an integer array nums consisting of n elements, and an integer k.
//
// Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
// Any answer with a calculation error less than 10-5 will be accepted.
//
// Example 1:
//
// Input: nums = [1,12,-5,-6,50,3], k = 4
// Output: 12.75000
// Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
// Example 2:
//
// Input: nums = [5], k = 1
// Output: 5.00000
public class MaximumAverageSubarray {
  public static void main(String[] args) {
    int[] nums = new int[]{1, 12, -5, -6, 50, 3};
    double result = new MaximumAverageSubarray().findMaxAverage(nums, 4);
    System.out.println(result);
  }

  public double findMaxAverage(int[] nums, int k) {
    int curr = 0;
    for (int i = 0; i < k; i++) {
      curr += nums[i];
    }

    int ans = curr;
    for (int i = k; i < nums.length; i++) {
      curr += nums[i] - nums[i - k];
      ans = Math.max(ans, curr);
    }

    return (double) ans / k;
  }
}
