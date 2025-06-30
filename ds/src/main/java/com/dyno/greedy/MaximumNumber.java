package com.dyno.greedy;

public class MaximumNumber {
  // Problem: 오직 하나의 숫자를 변경해서 최대 숫자를 응답해주세요.
  // Input: num = 9669
  // Output: = 9969
  // Constraints:
  // 1 <= num <= 10000
  // 변경사항이 없는 경우 그대로 응답.
  // Algorithm:
  // Step 1: 현재 최대값 을 주어진 num으로 할당.
  // Step 2: 루프를 돌면서 첫번째 자리 숫자를 9면 6으로 6이면 9로 변경
  // Step 3: 크기 비교해서 최대값보다 크면 최대값으로 변경
  // Step 4: 최대값 응답.

  // 최적화
  // 해당 알고리즘은 실제 작은숫자인 6만 변경하면 큰숫자가 나오게 되므로 max 값을 처리할 필요가 없다.
  public static void main(String[] args) {
    System.out.println(getMaximumNumber(9669));
    System.out.println(getMaximumNumber(9996));
    System.out.println(getMaximumNumber(9999));

    System.out.println(getMaximumNumber2(9669));
    System.out.println(getMaximumNumber2(9996));
    System.out.println(getMaximumNumber2(9999));
  }

  public static int getMaximumNumber(int num) throws IllegalArgumentException {
    if (num < 1 || num > 10000) {
      throw new IllegalArgumentException("1 ~ 10000 사이의 숫자만 입력 가능합니다. ");
    }
    StringBuilder sb = new StringBuilder();
    sb.append(num);
    // sb.rep
    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == '6') {
        sb.setCharAt(i, '9');
      }
    }

    return Integer.parseInt(sb.toString());
  }

  public static int getMaximumNumber2(int num) throws IllegalArgumentException {
    if (num < 1 || num > 10000) {
      throw new IllegalArgumentException("1 ~ 10000 사이의 숫자만 입력 가능합니다. ");
    }
    String numStr = String.valueOf(num);
    return Integer.parseInt(numStr.replaceFirst("6", "9"));
  }
}
