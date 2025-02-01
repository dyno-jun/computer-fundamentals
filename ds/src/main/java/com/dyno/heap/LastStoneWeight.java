package com.dyno.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
  public static void main(String[] args) {
    int[] stones = {1, 2, 3, 4, 5, 6};
    int result = new LastStoneWeight().lastStoneWeight(stones);

    System.out.println(result);
  }

  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

    for (int stone : stones) {
      heap.add(stone);
    }

    while (heap.size() > 1) {
      int first = heap.remove();
      int second = heap.remove();
      if (first != second) {
        heap.add(first - second);
      }
    }

    return heap.isEmpty() ? 0 : heap.remove();
  }
}
