package sort;

import common.SwapArray;

import java.util.Arrays;

public class Segregate0And1 {
  public static void main(String[] args) {
    int[] binaries = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
    segregate(binaries);
    System.out.println(Arrays.toString(binaries));
  }

  /*
   * The idea is based from Hoare's partition of Quick sort
   *
   *  Time complexity: O(n)
   * Space complexity: O(1)
   * */
  public static void segregate(int[] arr) {
    int low = 0, high = arr.length - 1;

    while (low < high) {
      if (arr[low] == 1) {
        if (arr[high] == 0) {
          SwapArray.swap(arr, low, high);
          low++;
        }
        high--;
      } else {
        low++;
      }
    }
  }
}
