package com.dyno.greedy;

import java.util.Arrays;

public class MaximumUnitsTruck {
  public static void main(String[] args) {
    // Problem: 주어진 boxTypes 배열에서 첫번째 인자는 박스수, 두번째 인자는 박스당 유닛수일때 truck에 실을수 있는 최대 유닛수를 구하라.
    // Input: int[][] boxTypes 박스수, 박스당 유닛수, truckSize: 한트럭에 실을수 있는 최대 박스수
    // Output: 트럭에 실린 최대 유닛수
    // Constraints:
    // 1.1 <= boxTypes.length <= 1000
    // 2. 1 <= box, unit <= 1000
    // 3. 1 <= truckSize <== 10^6
    // Algorithm
    // Step 1: 주어진 배열을 유닛수 기준으로 내림차순 정렬합니다.
    // Step 2: 루프를 돌면서 truckSize 만큼 박스당 유닛수를 계산해서 더합니다.
    // Step 3: 남은 갯수가 0이되면 break
    // Step 4: 계산된 unit 수를 응답합니다.

//    boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
    int[][] boxTypes = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
    int truckSize = 10;
    System.out.println(maximumUnits(boxTypes, truckSize));
  }

  public static int maximumUnits(int[][] boxTypes, int truckSize) {
    int result = 0;
    // Step 1: 주어진 배열을 유닛수 기준으로 내림차순 정렬합니다.
//    Arrays.sort(boxTypes, (a, b) -> a[1] - b[1]); // 오름차순
    Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]); // 정렬 방식 숙지
    // Step 2: 루프를 돌면서 truckSize 만큼 박스당 유닛수를 계산해서 더합니다.
    int remBox = truckSize;
    for (int[] boxType : boxTypes) {
      int box = boxType[0];
      int count = Math.min(box, remBox);
      int unit = boxType[1];

      remBox -= count;
      result += count * unit;

      // Step 3: 남은 갯수가 0이면
      if (remBox == 0) {
        break;
      }
    }

    return result;
  }
}
