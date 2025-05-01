package com.dyno.binarysearch;

import java.util.Arrays;

public class BinarySearchExample {
  public int binarySearch(int[] arr, int target) {
    Arrays.sort(arr);
    int left = 0;
    int right = arr.length - 1;
    // arr 의 경우 sorted array

    while (left <= right) {
      int mid = left + (right - left) / 2; // overflow
      if (arr[mid] == target) {
        return mid;
      }

      if (arr[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
