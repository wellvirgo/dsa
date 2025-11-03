package sort;

import java.util.Arrays;

public class InsertionSort {
  public static void main(String[] args) {
    int[] a = {2, 1, -2, 3, 0, 9, -1, -5, 100, 102, -1};
    sort(a);
    System.out.println(Arrays.toString(a));
  }

  /*
   * Time complexity: O(n^2)
   * Space complexity: O(1)
   * */
  static void sort(int[] a) {
    int n = a.length;

    for (int i = 1; i < n; i++) {
      int k = a[i];
      int j = i - 1;

      while (j >= 0 && a[j] > k) {
        a[j + 1] = a[j];
        j--;
      }

      a[j + 1] = k;
    }
  }
}
