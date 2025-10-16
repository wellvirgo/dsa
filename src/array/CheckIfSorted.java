package array;

public class CheckIfSorted {

  /*
   * Check a given int arr[] is sorted in ascending order or not.
   * 2 consecutive equal values are considered sorted.
   * */

  public static void main(String[] args) {
    int[] arr = {90, 80, 100, 70, 40, 30};
    System.out.println(isSortedIterative(arr));
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(1)
   * */
  static boolean isSortedIterative(int[] arr) {
    int n = arr.length;

    for (int i = 1; i < n; i++) {
      if (arr[i - 1] > arr[i]) return false;
    }

    return true;
  }

  /*
  * Time complexity: O(n)
  * Space complexity: O(n)
  * */
  static boolean isSortedRecursive(int[] arr, int n) {
    if (n == 1 || n == 0) return true;

    return arr[n - 1] >= arr[n - 2] && isSortedRecursive(arr, n - 1);
  }

  static boolean isSortedV1(int[] arr) {
    int n = arr.length;
    int max = arr[0];
    int i = 1;

    for (; i < n; i++) {
      if (arr[i] >= max) max = arr[i];
      else break;
    }

    return i == n;
  }
}
