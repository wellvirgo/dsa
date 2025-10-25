package search;

/**
 * The problem: Given a binary array arr[] of size n,
 * which is sorted in non-increasing order, count the number of 1's in it.
 */
public class CountOnesInBinary {
  public static void main(String[] args) {
    int[] arr = {1, 1, 0, 0, 0, 0, 0};
    System.out.println(countLinear(arr));
    System.out.println(countUseBinarySearch(arr));
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(1)
   * */
  static int countLinear(int[] arr) {
    int count = 0;
    for (int num : arr) {
      if (num < 1) break;

      if (num == 1) {
        count++;
      }
    }
    return count;
  }

  /*
   * Time complexity: O(log(n))
   * Space complexity: O(1)
   * */
  public static int countUseBinarySearch(int[] arr) {
    int n = arr.length;
    int low = 0, high = n - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      // If mid-element is 0
      if (arr[mid] == 0) high = mid - 1;

      // If element is last 1
      else if (mid == n - 1 || arr[mid + 1] != 1) return mid + 1;

      // If element is not last 1
      else low = mid + 1;
    }
    return 0;
  }
}
