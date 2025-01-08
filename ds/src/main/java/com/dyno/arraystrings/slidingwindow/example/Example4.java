package com.dyno.arraystrings.slidingwindow.example;

// Example 4:
// Given an integer array nums and an integer k,
// find the sum of the subarray with the largest sum whose length is k.
public class Example4 {
  public static void main(String[] args) {
    int[] nums = new int[]{3, -1, 4, 12, -8, 5, 6};
    int result = new Example4().findBestSubarray(nums, 4);
    System.out.println(result);
  }

  public int findBestSubarray(int[] nums, int k) {
    int curr = 0;
    for (int i = 0; i < k; i++) {
      curr += nums[i];
    }

    int ans = curr;
    for (int i = k; i < nums.length; i++) {
      curr += nums[i] - nums[i - k];
      ans = Math.max(ans, curr);
    }

    return ans;
  }
}
