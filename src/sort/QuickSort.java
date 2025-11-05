package sort;

import common.SwapArray;

import java.util.Arrays;

public class QuickSort {
  public static void main(String[] args) {
    int[] a = {10, 80, 30, 80, 40, 90, 40};
    sortV2(a, 0, a.length - 1);
    System.out.println(Arrays.toString(a));
  }

  /*
   * Choose the last element as Pivot
   * Using Lomuto partition
   * */
  static int lomutoPartition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j <= high; j++) {
      if (arr[j] < pivot) {
        i++;
        SwapArray.swap(arr, i, j);
      }
    }
    SwapArray.swap(arr, i + 1, high);
    return i + 1;
  }

  /*
   * Choose the first element as Pivot
   * Using Hoare's partition
   *
   * Fewer swap than Lomuto
   * */
  static int hoarePartition(int[] arr, int low, int high) {
    int pivot = arr[low];
    int i = low - 1;
    int j = high + 1;

    while (true) {
      do {
        i++;
      } while (arr[i] < pivot);

      do {
        j--;
      } while (arr[j] > pivot);

      if (i >= j) return j; // j is partition idx not pivot idx

      SwapArray.swap(arr, i, j);
    }
  }

  /*
   * Time complexity: O(n*log(n)) (avg); O(n^2) (worst)
   * Space complexity: O(log(n))
   * */
  static void sortV1(int[] arr, int low, int high) {
    if (low < high) {
      int pi = lomutoPartition(arr, low, high);
      sortV1(arr, low, pi - 1);
      sortV1(arr, pi + 1, high);
    }
  }

  /*
   * Time complexity: O(n*log(n)) (avg); O(n^2) (worst)
   * Space complexity: O(log(n))
   * */
  static void sortV2(int[] arr, int low, int high) {
    if (low < high) {
      int pi = hoarePartition(arr, low, high);
      sortV2(arr, low, pi);
      sortV2(arr, pi + 1, high);
    }
  }
}
