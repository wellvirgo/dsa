package search;

import java.util.ArrayList;

/**
 * The problem: Given an unsorted array arr[] of size n, containing elements from the range 1 to n,
 * it is known that one number in this range is missing and another number occurs twice in the
 * array. Find both the duplicate number and the missing number.
 */
public class MissingAndRepeating {
  public static void main(String[] args) {
    int[] arr = {4, 3, 6, 2, 1, 1};
    System.out.println(findMissingAndRepeatingUseVisitedArr(arr));
    System.out.println(findMissingAndRepeatingUseMarkingArr(arr));
  }

  /*
   * The idea: Use a frequency array to keep track how many times
   * each element appears in original array
   * if freq = 0 => missing
   * if freq = 2 => repeating
   *
   * Time complexity: O(n)
   * Space complexity: O(n)
   * */
  static ArrayList<Integer> findMissingAndRepeatingUseVisitedArr(int[] arr) {
    int n = arr.length;
    int[] freq = new int[n + 1];
    int missing = -1, repeating = -1;

    for (int i : arr) {
      freq[i]++;
    }

    var res = new ArrayList<Integer>();
    for (int i = 1; i <= n; i++) {
      if (freq[i] == 0) missing = i;
      else if (freq[i] == 2) repeating = i;
    }

    res.add(repeating);
    res.add(missing);

    return res;
  }

  /*
   * The idea: Use the input array itself for tracking.
   * Negate the value at the index corresponding to
   * the element to mark it is visited.
   * If it encounters a negated value => this number is repeating
   * It find the index remaining positive value => which corresponds to missing (index + 1)
   * */
  static ArrayList<Integer> findMissingAndRepeatingUseMarkingArr(int[] arr) {
    int n = arr.length;

    int repeating = -1;
    int missing = -1;

    // Val from 1 to n
    // index from 0 to n-1
    // Negate value at val-1 index to mark visited index
    for (int i = 0; i < n; i++) {
      int val = Math.abs(arr[i]);

      if (arr[val - 1] > 0) {
        arr[val - 1] = -arr[val - 1];
      } else {
        repeating = val;
      }
    }

    for (int i = 0; i < n; i++) {
      if (arr[i] > 0) {
        missing = i + 1;
        break;
      }
    }

    var res = new ArrayList<Integer>();
    res.add(repeating);
    res.add(missing);
    return res;
  }
}
