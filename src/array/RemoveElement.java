package array;

import java.util.Arrays;

public class RemoveElement {
  public static void main(String[] args) {
    int[] arr = {0, 1, 3, 0, 2, 2, 4, 2};
    int ele = 2;
    System.out.println("\n" + removeElement(arr, ele));
    System.out.println(Arrays.toString(arr));
  }

  /*
  * Problem: Given an arr[] and int ele. Have to remove all occurrences of ele in arr[]
  * and return the number of elements which are not equal to ele
  *
  * Approach: Iterate over the arr[] and use k to track the arr[].
  * Whenever encounter an element which are not equal to ele,
  * add it at kth index and increment the value of k.
  * Finally, arr[] will contain the first k element which are not equal to ele
  * and remaining elements can contain any element.
  *
  * Time complexity: O(n)
  * Space complexity: O(1)
  * */
  static int removeElement(int[] nums, int ele) {
    int k = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != ele) {
        nums[k] = nums[i];
        k++;
      }
    }

    for (int i = 0; i < k; i++) {
      System.out.print(nums[i] + " ");
    }

    return k;
  }
}
