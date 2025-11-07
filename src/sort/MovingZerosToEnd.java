package sort;

import common.SwapArray;

import java.util.Arrays;

public class MovingZerosToEnd {
  /*
   * Problem:
   * Given an int[] array, move all zero to end of the array
   * while maintaining the relative order of all non-zero elements
   * */

  public static void main(String[] args) {
    int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
    pushZerosToEndUse1Traversal(arr);
    System.out.println(Arrays.toString(arr));
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(n)
   * */
  static void pushZerosToEndUseTempArr(int[] arr) {
    int n = arr.length;

    int count = 0;
    for (int ele : arr) {
      if (ele == 0) count++;
    }

    int[] zeroArr = new int[count];
    int[] noneZeroArr = new int[n - count];

    int zeroIdx = 0;
    int nonZeroIdx = 0;
    for (int ele : arr) {
      if (ele != 0) {
        noneZeroArr[nonZeroIdx] = ele;
        nonZeroIdx++;
      } else {
        zeroArr[zeroIdx] = ele;
        zeroIdx++;
      }
    }

    System.arraycopy(noneZeroArr, 0, arr, 0, noneZeroArr.length);
    System.arraycopy(zeroArr, 0, arr, noneZeroArr.length, zeroArr.length);
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(1)
   * */
  static void pushZerosToEndUse2Traversals(int[] arr) {
    int n = arr.length;
    int count = 0; // Keep track the non-zero ele
    for (int ele : arr) {
      if (ele != 0) {
        arr[count++] = ele;
      }
    }

    for (int i = count; i < n; i++) {
      arr[i] = 0;
    }
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(1)
   * */
  static void pushZerosToEndUse1Traversal(int[] arr) {
    int n = arr.length;
    int count = 0;

    for (int i = 0; i < n; i++) {
      if (arr[i] != 0) {
        SwapArray.swap(arr, count, i);
        count++;
      }
    }
  }
}
