package com.dyno.queue;

import java.util.LinkedList;
import java.util.Queue;

//Example: 933. Number of Recent Calls
//Implement the RecentCounter class. It should support ping(int t), which records a call at time t, and then returns an integer representing the number of calls that have happened in the range [t - 3000, t]. Calls to ping will have increasing t.
public class QueueExample {
  Queue<Integer> queue;

  public QueueExample() {
    queue = new LinkedList<>();
  }

  public static void main(String[] args) {
//    System.out.println(result);
  }

  public int ping(int t) {
    while (!queue.isEmpty() && queue.peek() < t - 3000) {
      queue.poll();
    }

    queue.offer(t);
    return queue.size();
  }
}
