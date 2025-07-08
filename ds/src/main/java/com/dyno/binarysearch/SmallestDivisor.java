package com.dyno.binarysearch;
// Given an array of integers nums and an integer threshold, we will choose a positive integer divisor,
// divide all the array by it, and sum the division's result.
// Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
// Each result of the division is rounded to the nearest integer greater than or equal to that element.
// (For example: 7/3 = 3 and 10/2 = 5).
// The test cases are generated so that there will be an answer.


// Example 2:
// Input: nums = [44,22,33,11,1], threshold = 5
// Output: 44

// Constraints:
// 1 <= nums.length <= 5 * 104
// 1 <= nums[i] <= 106
// nums.length <= threshold <= 106

import java.util.Arrays;

public class SmallestDivisor {

  public static void main(String[] args) {
    int[] nums = new int[]{44, 22, 33, 11, 1};
    int threshold = 5;
    System.out.println(smallestDivisor(nums, threshold));
  }

  public static int smallestDivisor(int[] nums, int threshold) {
    // Problem: 몫의 합이 주어진 threshold 보다 작아지는 최소 divisor를 찾는 문제.
    // Input: nums = [44,22,33,11,1], threshold = 5
    // Output: 몫의 합이 가장 최소가 되는 divisor 구하기
    // Constraints:
    // Algorithm:
    // 나누는 인자가 커질수록 몫이 작아지므로 binary search 를 사용해서 탐색 진행
    int low = 1;
    int high = Arrays.stream(nums).max().getAsInt();

    while (low <= high) {
      int mid = low + (high - low) / 2;
      int sum = 0;
      for (int num : nums) {
        sum += (int) Math.ceil((double) num / mid);
      }

      if (sum > threshold) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return low;
  }
}
