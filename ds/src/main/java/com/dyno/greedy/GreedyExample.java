package com.dyno.greedy;

import java.util.Arrays;

public class GreedyExample {
  public static void main(String[] args) {
    int mass = 100;
    int[] asteroids = new int[]{1, 2, 3, 4, 5};

    boolean result = canDestroyAll(mass, asteroids);
    System.out.println(result);
  }

  private static boolean canDestroyAll(int mass, int[] asteroids) {
    Arrays.sort(asteroids);
    for (int as : asteroids) {
      if (as > mass) {
        return false;
      }
      mass += as;
    }

    return true;
  }
}
