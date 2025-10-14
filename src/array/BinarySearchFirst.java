package array;

public class BinarySearchFirst {
  public static void main(String[] args) {
    int[] arr = {1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5};
    System.out.println(binarySearchFirst(arr, 3));
  }

  static int binarySearchFirst(int[] arr, int k) {
    int low = 0;
    int high = arr.length - 1;
    int result = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (arr[mid] == k) {
        result = mid;

        // Continue searching to the left to find the first occurrence
        high = mid - 1;

        /*
         * Continue searching to the right to find the last occurrence
         * low = mid + 1;
         * */

      } else if (arr[mid] > k) {
        high = mid - 1;
      } else low = mid + 1;
    }

    return result;
  }
}
