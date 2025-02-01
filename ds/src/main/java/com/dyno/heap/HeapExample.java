package com.dyno.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapExample {

  public static void main(String[] args) {
    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
    int[] nums = {67, 341, 234, -67, 12, -976};

    for (int num : nums) {
      heap.add(num);
    }

    heap.add(7451);
    heap.add(-5352);

    while (!heap.isEmpty()) {
      System.out.println(heap.remove());
    }
  }
}
