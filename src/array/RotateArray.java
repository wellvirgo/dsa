package array;

import common.GCD;

import java.util.Arrays;

public class RotateArray {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6};
    rotateUseReversal(arr, 2);
    System.out.println(Arrays.toString(arr));
  }

  /*
   * Time complexity: O(n^2)
   * Space complexity: O(1)
   * */
  static void rotateUseNestedLoop(int[] arr, int d) {
    int n = arr.length;

    for (int i = 0; i < d; i++) {
      int last = arr[n - 1];
      for (int j = n - 1; j > 0; j--) {
        arr[j] = arr[j - 1];
      }
      arr[0] = last;

      System.out.println(i + " - " + Arrays.toString(arr));
    }
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(n)
   * */
  static void rotateUseTempArray(int[] arr, int d) {
    int n = arr.length;
    d %= n;
    int[] temp = new int[n];

    for (int i = 0; i < d; i++) {
      temp[i] = arr[n - d + i];
    }

    for (int i = 0; i < n - d; i++) {
      temp[i + d] = arr[i];
    }

    System.arraycopy(temp, 0, arr, 0, n);
  }

  /**
   * Rotate the array to the right using the Juggling Algorithm
   *
   * <p>The idea behind Juggling Algorithm is that instead of moving one by one, we can use the
   * concept of cycles. Each cycle is independent and represents a group of elements that will shift
   * among themselves during the rotation. If the starting index of a cycle is i, then the next
   * elements will be present at indices (i + d) % n, (i + 2d) % n, (i + 3d) % n ... and so on till
   * we reach back to index i. So for any index i, we know that element at index i will move to
   * index (i + d) % n
   *
   * <p>Time complexity: O(n)<br>
   * Space complexity: O(1)
   *
   * @param arr input integer array
   * @param d times to rotate the array
   */
  static void rotateUseJuggling(int[] arr, int d) {
    int n = arr.length;

    // Optimize rotation count when d > n
    // After n rotations, the array returns to it original state
    d %= n;

    // Calculate the number of cycles in the rotation
    int cycles = GCD.gcd(n, d);

    for (int i = 0; i < cycles; i++) {
      // Initialize start index and value of current cycle
      int currIdx = i;
      int currEle = arr[currIdx];

      // Rotate elements will we reach the start index of cycle
      do {

        int nextIdx = (currIdx + d) % n;
        int nextEle = arr[nextIdx];

        // Update the element at next index with the current element
        arr[nextIdx] = currEle;

        // Update currEle to nextEle
        currEle = nextEle;

        // Move to the next index
        currIdx = nextIdx;

      } while (currIdx != i);
    }
  }

  /**
   * The idea is based on the observation that if we right rotate the array by d positions,
   * the last d elements will be in the front and first (n - d) elements will be at the end.
   *
   * @param arr input integer array
   * @param d times to rotate the array
   */
  static void rotateUseReversal(int[] arr, int d) {
    int n = arr.length;
    d %= n;

    // Reverse the entire array
    reverse(arr, 0, n - 1);

    // Reverse the first d elements
    reverse(arr, 0, d - 1);

    // Revers the last n-d elements
    reverse(arr, d, n - 1);
  }

  private static void reverse(int[] arr, int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;

      start++;
      end--;
    }
  }
}
