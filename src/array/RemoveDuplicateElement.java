package array;

import java.util.*;

public class RemoveDuplicateElement {
  /*
   * Given a sorted array of size n.
   * The goal is to rearrange arr so that
   * all distinct elements appear at the beginning in sorted order.
   * Return the length of rearranged subarray.
   * */

  public static void main(String[] args) {
    int[] arr = {2, 2, 2, 2, 2};
    System.out.println(removeDuplicates(arr));
    System.out.println(removeDuplicatesUseArrayList(arr));
  }

  /**
   * Removes consecutive duplicate elements from the given array.
   *
   * <p>In each iteration, the method counts all consecutive equal elements and adds the last
   * element of that group to the result array.
   *
   * <p>Time complexity: O(n^2)<br>
   * Space complexity: O(n)
   *
   * @param nums the input sorted array of integers
   * @return Object[] an array of unique element
   */
  static Object[] ownRemoveDuplicates(int[] nums) {
    int n = nums.length;
    ArrayList<Integer> subArray = new ArrayList<>();

    for (int i = 0; i < n; ) {
      int count = 0;

      for (int j = i; j < n; j++) {
        if (nums[j] == nums[i]) {
          count++;
        }
      }

      // Add the last element of the current group of equal element
      subArray.add(nums[i + count - 1]);

      // Move to the first element after the current group of equal element
      i += count;
    }

    return subArray.toArray();
  }

  /**
   * Use an ArrayList to store the distinct elements
   *
   * <p>Time complexity: O(n)<br>
   * Space complexity: O(n)
   *
   * @param nums the input sorted array of integers
   * @return ArrayList of unique element
   */
  static ArrayList<Integer> removeDuplicatesUseArrayList(int[] nums) {
    ArrayList<Integer> arrList = new ArrayList<>();

    for (int ele : nums) {
      if (!arrList.contains(ele)) {
        arrList.add(ele);
      }
    }

    return arrList;
  }

  /**
   * Time complexity: O(n)<br>
   * Space complexity: O(1) since only returns the count of distinct elements.
   *
   * @param nums the input sorted array of integers
   * @return the count of distinct elements
   */
  static int removeDuplicates(int[] nums) {
    int n = nums.length;
    int idx = 1;

    for (int i = 1; i < n; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[idx++] = nums[i];
      }
    }
    return idx;
  }
}
