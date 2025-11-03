package sort;

import common.SwapArray;

import java.util.Arrays;

public class SelectionSort {
  public static void main(String[] args) {
    int[] a = {2, 1, -2, 3, 0, 9, -1, -5, 100, 102, -1};

    sort(a);

    System.out.println(Arrays.toString(a));
  }

  /*
   * Time complexity: O(n^2)
   * Space complexity: O(1)
   * */
  static void sort(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
      int minIdx = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[minIdx]) {
          minIdx = j;
        }
      }

      if (minIdx != i) {
        SwapArray.swap(arr, i, minIdx);
      }
    }
  }
}
