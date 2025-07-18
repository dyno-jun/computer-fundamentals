package com.dyno.arraystrings.sort;

public class SelectionSort {

  public static void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      int minIdx = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[minIdx]) {
          minIdx = j;
        }
      }
      // Swap the found minimum element with the first element
      int temp = arr[minIdx];
      arr[minIdx] = arr[i];
      arr[i] = temp;
    }
  }

  public static void main(String[] args) {
    int[] arr = {64, 34, 25, 12, 22, 11, 90};
    selectionSort(arr);
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }

  public void selection(int[] arr) {
    int size = arr.length;

    for (int i = 0; i < size - 1; i++) {
      int minIdx = i;
      for (int j = i + 1; j < size; j++) {
        if (arr[j] < arr[minIdx]) {
          minIdx = j;
        }
      }

      int temp = arr[minIdx];
      arr[minIdx] = arr[i];
      arr[i] = temp;
    }
  }
}
