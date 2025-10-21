package search;

import java.util.Arrays;

public class LargestInArray {
  public static void main(String[] args) {
    int[] arr = {30, 10, 30, 20, 25};
    System.out.println(largest(arr));
    System.out.println(secondLargestUseSort(arr));
    System.out.println(secondLargestUseTwoPassSearch(arr));
    System.out.println(secondLargestUseOnePassSearch(arr));
  }

  public static int largest(int[] arr) {
    int max = arr[0];
    for (int ele : arr) {
      if (ele > max) max = ele;
    }
    return max;
  }

  // The below algorithm to find second largest in positive array
  // To handle non-positive array
  // use Integer.MIN_VALUE instead of -1

  /*
   * Time complexity: O(n*log(n))
   * Space complexity: O(1)
   * */
  public static int secondLargestUseSort(int[] arr) {
    Arrays.sort(arr);
    int n = arr.length;

    for (int i = n - 2; i >= 0; i--) {
      if (arr[i] != arr[n - 1]) {
        return arr[i];
      }
    }

    return -1;
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(1)
   * */
  public static int secondLargestUseTwoPassSearch(int[] arr) {
    int largest = largest(arr);
    int secondLargest = -1;
    for (int ele : arr) {
      if (ele != largest && ele > secondLargest) secondLargest = ele;
    }
    return secondLargest;
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(1)
   * */
  public static int secondLargestUseOnePassSearch(int[] arr) {
    int largest = -1, secondLargest = -1;

    for (int currEle : arr) {
      if (currEle > largest) {
        secondLargest = largest;
        largest = currEle;
      } else if (currEle < largest && currEle > secondLargest) {
        secondLargest = currEle;
      }
    }

    return secondLargest;
  }
}
