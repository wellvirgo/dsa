package search;

import java.util.Arrays;

public class TopThreeLargest {
  public static void main(String[] args) {
    int[] arr = {-1, -90, 2, -5, 100};
    System.out.println(Arrays.toString(getTopThreeLargest(arr)));
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(1)
   * */
  static int[] getTopThreeLargest(int[] arr) {
    // Integer.MIN_VALUE is -INF, to handle non-positive array
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;
    int thirdLargest = Integer.MIN_VALUE;

    for (int currEle : arr) {
      if (currEle > largest) {
        thirdLargest = secondLargest;
        secondLargest = largest;
        largest = currEle;
      } else if (currEle < largest && currEle > secondLargest) {
        thirdLargest = secondLargest;
        secondLargest = currEle;
      } else if (currEle < secondLargest && currEle > thirdLargest) {
        thirdLargest = currEle;
      }
    }

    if (largest == Integer.MIN_VALUE) return new int[0];
    else if (secondLargest == Integer.MIN_VALUE) return new int[] {largest};
    else if (thirdLargest == Integer.MIN_VALUE) return new int[] {largest, secondLargest};
    else return new int[] {largest, secondLargest, thirdLargest};
  }
}
