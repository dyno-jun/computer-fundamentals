package com.dyno.binarysearch;

import java.util.Arrays;

public class LongestSubsequence {
  public static void main(String[] args) {
    LongestSubsequence insertion = new LongestSubsequence();

    int[] nums = {4, 5, 2, 1};
    int[] queries = {3, 10, 21};
    int[] result = insertion.answerQueries(nums, queries);

    System.out.println(Arrays.toString(result)); // 출력: [2, 3, 4]
  }

  public int[] answerQueries(int[] nums, int[] queries) {
    int[] results = new int[queries.length];
    Arrays.sort(nums);
    int[] prefixSum = new int[nums.length];
    prefixSum[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i];
    }

    for (int i = 0; i < queries.length; i++) {
      results[i] = upperBound(prefixSum, queries[i]);
    }

    return results;
  }

  private int upperBound(int[] prefixSum, int target) {
    int left = 0, right = prefixSum.length;

    while (left < right) {
      int mid = left + (right - left) / 2;

      if (prefixSum[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left; // 만족하는 최대 길이
  }

}


