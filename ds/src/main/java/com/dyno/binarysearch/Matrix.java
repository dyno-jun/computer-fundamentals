package com.dyno.binarysearch;

public class Matrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    int left = 0;
    int right = m * n - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      int row = mid / n; // matrix[0].length 인 한줄 크기의 몫 이 row index
      int col = mid % n; // matrix[0].length 인 한줄 크기의 나머지가 col index
      int num = matrix[row][col];

      if (num == target) {
        return true;
      }

      if (num < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return false;
  }
}
