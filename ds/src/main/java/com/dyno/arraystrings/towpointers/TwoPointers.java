package com.dyno.arraystrings.towpointers;

import java.util.ArrayList;
import java.util.List;

public class TwoPointers {

  public boolean checkIfPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }

      left++;
      right--;
    }

    return true;
  }

  public boolean checkForTarget(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      int curr = nums[left] + nums[right];
      if (curr == target) {
        return true;
      }

      if (curr > target) {
        right--;
      } else {
        left++;
      }
    }

    return false;
  }

  public List<Integer> combine(int[] arr1, int[] arr2) {
    // ans is the answer
    List<Integer> ans = new ArrayList<>();
    int i = 0;
    int j = 0;

    while (i < arr1.length && j < arr2.length) {
      if (arr1[i] < arr2[j]) {
        ans.add(arr1[i]);
        i++;
      } else {
        ans.add(arr2[j]);
        j++;
      }
    }

    while (i < arr1.length) {
      ans.add(arr1[i]);
      i++;
    }

    while (j < arr2.length) {
      ans.add(arr2[j]);
      j++;
    }

    return ans;
  }

  public boolean isSubsequence(String s, String t) {
    int i = 0;
    int j = 0;

    while (i < s.length() && j < t.length()) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
      }
      j++;
    }

    return i == s.length();
  }

  public void bubbleSort(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length - 1 - i; j++) {}
    }
  }
}
