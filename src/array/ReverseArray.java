package array;

import java.util.Arrays;

public class ReverseArray {
  public static void main(String[] args) {
    int[] arr = {1, 4, 3, 2, 6, 5};
    System.out.println(Arrays.toString(reverseArray(arr)));

    reverseUseTwoPointers(arr);
    System.out.println(Arrays.toString(arr));

    reverseUseSwap(arr);
    System.out.println(Arrays.toString(arr));
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(n)
   * */
  static int[] reverseArray(int[] arr) {
    int n = arr.length;
    int[] reversed = new int[n];

    for (int i = 0; i < n; i++) {
      reversed[i] = arr[n - i - 1];
    }

    return reversed;
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(1)
   * */
  static void reverseUseTwoPointers(int[] arr) {
    int n = arr.length;
    int left = 0, right = n - 1;

    for (int i = 0; i < n; i++) {
      if (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        left++;
        right--;
      }
    }
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(1)
   * */
  static void reverseUseSwap(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[n - i - 1];
      arr[n - i - 1] = temp;
    }
  }
}
