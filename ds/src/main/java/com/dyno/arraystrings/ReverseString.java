package com.dyno.arraystrings;

// Write a function that reverses a string. The input string is given as an array of characters s.
// You must do this by modifying the input array in-place with O(1) extra memory.
//
// Example 1:
//
// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]
// Example 2:
//
// Input: s = ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]

public class ReverseString {
  public static void main(String[] args) {
    Solution solution = new Solution();
    char[] s = new char[] {'h', 'e', 'l', 'l', 'o'};
    solution.reverseString(s);
  }
}

class Solution {
  public void helper(char[] s, int left, int right) {
    if (left >= right) return;
    char tmp = s[left];
    s[left++] = s[right];
    s[right--] = tmp;
    helper(s, left, right);
  }

  public void reverseString(char[] s) {
    helper(s, 0, s.length - 1);
  }
}
