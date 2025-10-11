package sort;

import java.util.Arrays;

public class BubbleSort {
  public static void main(String[] args) {
    int[] a = {2, 1, -2, 3, 0, 9, -1, -5, 100, 102, -1};

    sort(a);

    System.out.println(Arrays.toString(a));
  }

  /*
  * Time complexity: O(n^2)
  * Space complexity: O(n)
  * */
  static void sort(int[] a) {
    int n = a.length;
    boolean swapped;

    for (int i = 0; i < n - 1; i++) {
      swapped = false;
      for (int j = 0; j < n - i - 1; j++) {
        if (a[j] > a[j + 1]) {
          swap(a, j, j + 1);
          swapped = true;
        }
      }
      if (!swapped) break;
    }
  }

  static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
