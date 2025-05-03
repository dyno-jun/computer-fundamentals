package com.dyno.binarysearch;

public class Insertion {
  public static void main(String[] args) {
    Insertion insertion = new Insertion();
    int[] nums = {1, 3, 5, 6};
    int index = insertion.searchInsert(nums, 0);

    System.out.println(index);
  }

  public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target) {
        return mid;
      }

      if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }
}


