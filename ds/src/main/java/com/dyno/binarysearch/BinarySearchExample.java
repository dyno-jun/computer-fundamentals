package com.dyno.binarysearch;

//Example 1: 704. Binary Search
//
//You are given an array of integers nums which is sorted in ascending order, and an integer target.
// If target exists in nums, return its index. Otherwise, return -1.

public class BinarySearchExample {
  public int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == target) {
        return mid;
      }
      if (arr[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    // target is not in arr, but left is at the insertion point
    return -1;
  }
}
