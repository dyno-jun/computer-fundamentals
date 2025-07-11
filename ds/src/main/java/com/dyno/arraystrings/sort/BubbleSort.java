package com.dyno.arraystrings.sort;

public class BubbleSort {

  public static void bubbleTest(int[] arr) {
    int size = arr.length;
    for (int i = 0; i < size - 1; i++) {
      boolean isSwapped = false;
      for (int j = 0; j < size - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          isSwapped = true;
        }
      }
      if (!isSwapped) break;
    }
  }

  public static void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      boolean swapped = false;
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          // Swap arr[j] and arr[j+1]
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swapped = true;
        }
      }
      // If no two elements were swapped, break
      if (!swapped) break;
    }
  }

  public static void main(String[] args) {
    int[] arr = {64, 34, 25, 12, 22, 11, 90};
    bubbleSort(arr);
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}
