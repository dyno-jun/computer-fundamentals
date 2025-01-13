package com.dyno.hash;

import java.util.Arrays;

public class MissingNum {
  public static void main(String[] args) {
    int[] arr = {3, 0, 1};
    int result = new MissingNum().missingNumber(arr);
    System.out.println(result);
  }
//
//  public int missingNumber(int[] nums) {
//    HashSet<Integer> hash = new HashSet<>();
//    int length = nums.length;
//    for (int i = 0; i <= length; i++) {
//      hash.add(i);
//    }
//
//    for (int num : nums) {
//      hash.remove(num);
//    }
//
//    return hash.iterator().next();
//  }

  public int missingNumber(int[] nums) {
    Arrays.sort(nums);

    // Ensure that n is at the last index
    if (nums[nums.length - 1] != nums.length) {
      return nums.length;
    }
    // Ensure that 0 is at the first index
    else if (nums[0] != 0) {
      return 0;
    }

    // If we get here, then the missing number is on the range (0, n)
    for (int i = 1; i < nums.length; i++) {
      int expectedNum = nums[i - 1] + 1;
      if (nums[i] != expectedNum) {
        return expectedNum;
      }
    }

    // Array was not missing any numbers
    return -1;
  }
}
