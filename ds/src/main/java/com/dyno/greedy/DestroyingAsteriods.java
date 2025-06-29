package com.dyno.greedy;

import java.util.Arrays;

public class DestroyingAsteriods {
  public static void main(String[] args) {
    // Problem: 주어진 소행성들을 mass가 다 부술수 있는지를 찾는 문제 입니다.
    // Input: int[] asteroids, int mass
    // Output: boolean (can all delete)
    // Constraints: mass> asteroid 일대 mass += asteroid 그렇지 않으면 부수지 못하고 false return

    // [Pseudocode]
    // Step 1: 소행성 목록을 배열로 정리합니다.
    // Step 2: 소행성 목록 만큼 루프를 돌면서 mass 보다 작은 경우 mass += 소행성 아닌경우 false 로 응답합니다.
    // Step 3: 다부수었으면 true 를 응답합니다.
    int[] asteriods = {1, 3, 5, 2};
    int mass = 10;
    System.out.println(canDestroyAsteriods(asteriods, mass));
  }

  public static boolean canDestroyAsteriods(int[] asteriods, int mass) {
    Arrays.sort(asteriods);
    for (int a : asteriods) {
      if (mass > a) {
        mass += 1;
      } else {
        return false;
      }
    }

    return true;
  }
}
