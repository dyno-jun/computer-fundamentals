package com.dyno.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumOperation {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6};
    int result = new MinimumOperation().halfArray(nums);

    System.out.println(result);
  }

  public int halfArray(int[] nums) {
    double target = 0;
    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

    for (int num : nums) {
      target += num;
      heap.add(num);
    }

    target /= 2;
    int ans = 0;

    while (target > 0) {
      ans++;
      double x = heap.remove();
      target -= (x / 2);
      heap.add((int) (x / 2));

    }

    return ans;
  }
}
