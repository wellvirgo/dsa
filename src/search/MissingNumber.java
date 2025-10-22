package search;

import java.util.HashMap;
import java.util.Map;

public class MissingNumber {
  /*
   * Given an array of n-1 size
   * with distinct element in [1, n]
   * Return the missing num in given array
   * */

  public static void main(String[] args) {
    int[] arr = {8, 2, 4, 5, 3, 7, 1};
    System.out.println(findUseNestedLoop(arr));
    System.out.println(findUseHashing(arr));
    System.out.println(findUseSumOfNumbers(arr));
    System.out.println(findUseXOR(arr));
  }

  /*
   * Time complexity: O(n^2)
   * Space complexity: O(1)
   * */
  static int findUseNestedLoop(int[] arr) {
    int length = arr.length;
    int n = length + 1;

    for (int i = 1; i <= n; i++) {
      boolean exist = false;
      for (int ele : arr) {
        if (ele == i) {
          exist = true;
          break;
        }
      }
      if (!exist) return i;
    }

    return -1;
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(n)
   * */
  static int findUseHashing(int[] arr) {
    int length = arr.length;
    int n = length + 1;
    Map<Integer, Integer> map = new HashMap<>();

    for (int ele : arr) {
      map.put(ele, ele);
    }

    for (int i = 1; i <= n; i++) {
      if (!map.containsKey(i)) return i;
    }

    return -1;
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(1)
   *
   * Caution: this algorithm will be integer overflow
   * */
  static int findUseSumOfNumbers(int[] arr) {
    int sum = 0;
    int n = arr.length + 1;
    for (int ele : arr) {
      sum += ele;
    }

    int expSum = n * (n + 1) / 2;
    return expSum - sum;
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(1)
   * */
  static int findUseXOR(int[] arr) {
    int n = arr.length + 1;
    int xor = 0, expXor = 0;

    for (int i = 1; i <= n; i++) {
      expXor ^= i;
    }

    for (int ele : arr) {
      xor ^= ele;
    }

    return expXor ^ xor;
  }
}
