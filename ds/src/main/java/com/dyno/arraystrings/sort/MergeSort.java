package com.dyno.arraystrings.sort;

public class MergeSort {
  public static void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;

      // Divide
      mergeSort(arr, left, mid);
      mergeSort(arr, mid + 1, right);

      // Conquer
      merge(arr, left, mid, right);
    }
  }

  private static void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int[] leftArray = new int[n1];
    int[] rightArray = new int[n2];

    // Copy data to temp arrays
    System.arraycopy(arr, left, leftArray, 0, n1);
    for (int j = 0; j < n2; j++) rightArray[j] = arr[mid + 1 + j];

    int i = 0, j = 0, k = left;

    // Merge temp arrays back into arr
    while (i < n1 && j < n2) {
      if (leftArray[i] <= rightArray[j]) {
        arr[k] = leftArray[i];
        i++;
      } else {
        arr[k] = rightArray[j];
        j++;
      }
      k++;
    }

    // Copy remaining elements of leftArray
    while (i < n1) {
      arr[k] = leftArray[i];
      i++;
      k++;
    }

    // Copy remaining elements of rightArray
    while (j < n2) {
      arr[k] = rightArray[j];
      j++;
      k++;
    }
  }

  public static void main(String[] args) {
    int[] arr = {64, 34, 25, 12, 22, 11, 90};
    mergeSort(arr, 0, arr.length - 1);
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}
