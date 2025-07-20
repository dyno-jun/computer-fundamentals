package com.dyno.binarysearch;

// You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.
// You want to share the chocolate with your k friends so you start cutting the chocolate bar into k + 1 pieces using k cuts, each piece consists of some consecutive chunks.
// Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.
// Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
// Example 1:
// Input: sweetness = [1,2,3,4,5,6,7,8,9], k = 5
// Output: 6
// Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
// Example 2:
// Input: sweetness = [5,6,7,8,9,1,2,3,4], k = 8
// Output: 1
// Explanation: There is only one way to cut the bar into 9 pieces.
// Example 3:
// Input: sweetness = [1,2,2,1,2,2,1,2,2], k = 2
// Output: 5
// Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]

public class DivideChocolate {
  public static void main(String[] args) {
    // Problem:
    // Input: sweetness = [1,2,3,4,5,6,7,8,9], k = 5
    // Output: 최대 조각수를 구하기
    // Constraints:
    // Algorithm:
    // Step1: 전체 합 구하기
    // Step2: binarySearch 를 활용해 최대 조각 추출
    System.out.println(maximizeSweetness(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5));
    System.out.println(maximizeSweetness(new int[]{5, 6, 7, 8, 9, 1, 2, 3, 4}, 8));
    System.out.println(maximizeSweetness(new int[]{1, 2, 2, 1, 2, 2, 1, 2, 2}, 2));
  }

  public static int maximizeSweetness(int[] sweetness, int k) {
    int left = 1;
    int right = 0;
    for (int s : sweetness) {
      right += s; // 전체 합이 최댓값이 될 수 있음
    }

    int answer = 0;

    while (left <= right) {
      int mid = (left + right) / 2;
      int pieces = 0;
      int currentSum = 0;

      for (int s : sweetness) {
        currentSum += s;
        if (currentSum >= mid) {
          pieces++;   // 한 덩어리로 나눔
          currentSum = 0;
        }
      }

      if (pieces >= k + 1) {
        // 나눌 수 있다면 더 큰 최소값을 시도
        answer = mid;
        left = mid + 1;
      } else {
        // 나눌 수 없다면 더 작은 값으로 시도
        right = mid - 1;
      }
    }

    return answer;
  }
}
