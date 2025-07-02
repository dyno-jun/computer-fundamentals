package com.dyno.greedy;

import java.util.Arrays;

public class HowManyApple {

  public static void main(String[] args) {
    // Problem: 한바구니에 최대로 옮길수 있는 사과 수는?
    // Input: weight[] 각 사과 무게
    // Output: 옮길수 있는 사과 수
    // Constraints: 1 <= weight.length <= 10^3,
    // Algorithm
    // Step 1: sort by weight asc
    // Step 2: for loop each weight -= weight
    // Step 3: if baketWeight >= < weight 되는 순간 break

    int[] weights = {988, 641, 984, 635, 461, 527, 491, 610, 274, 104, 348, 468, 220, 837, 126, 111, 536, 368, 89, 201, 589, 481, 849, 708, 258, 853, 563, 868, 92, 76, 566, 398, 272, 697, 584, 851, 302, 766, 88, 428, 276, 797, 460, 244, 950, 134, 838, 161, 15, 330};
    System.out.println(maxNumberOfApples(weights));
  }

  public static int maxNumberOfApples(int[] weights) {
    int result = 0;
    int baketWeight = 5000;
    Arrays.sort(weights);
    for (int weight : weights) {
      baketWeight -= weight;
      if (baketWeight >= 0) {
        result += 1;
      } else {
        break;
      }
    }

    return result;
  }
}
