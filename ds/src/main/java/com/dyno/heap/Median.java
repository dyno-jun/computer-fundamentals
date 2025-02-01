package com.dyno.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Median {

  private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

  public static void main(String[] args) {
    Median median = new Median();
    int[] stones = {1, 3, 7, 13, 36, 100};

    for (int i : stones) {
      median.addNum(i);
    }

    median.addNum(50);

    System.out.println(median.findMedian());
  }

  public void addNum(int num) {
    maxHeap.add(num);
    minHeap.add(maxHeap.remove());
    if (minHeap.size() > maxHeap.size()) {
      maxHeap.add(minHeap.remove());
    }
  }

  public double findMedian() {
    if (maxHeap.size() > minHeap.size()) {
      return maxHeap.peek();
    }

    return (minHeap.peek() + maxHeap.peek()) / 2.0;
  }
}
