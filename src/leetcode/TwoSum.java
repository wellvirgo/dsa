package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public static void main(String[] args) {
    int[] arr = {1, 0, 2, 11, 9, 8, 5};
    int target = 9;
    System.out.println(Arrays.toString(twoSum1PassHash(arr, target)));

    int[] arr2 = {-5, -1, 0, 1, 2};
    int target2 = -5;
    System.out.println(Arrays.toString(twoSumUseTwoPointer(arr2, target2)));
  }

  /**
   * Using a HashMap to find 2 indices in the array such that the elements at those indices add up
   * to the target value
   *
   * <p>Time complexity: O(n)<br>
   * Space complexity: O(n)
   *
   * @param nums an array of integers
   * @param target the target sum to find
   * @return an array containing the indices of 2 elements whose sum equals the target
   */
  static int[] twoSum1PassHash(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        // Assure the returned indices are in ascending order
        return new int[] {Math.min(i, map.get(complement)), Math.max(i, map.get(complement))};
      }

      // Put currEle into map
      // if its corresponding isn't already exists in map
      map.put(nums[i], i);
    }

    return new int[] {};
  }

  static int[] twoSum2PassHash(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];

      if (map.containsKey(complement) && map.get(complement) != i)
        return new int[] {i, map.get(complement)};
    }

    return new int[] {};
  }

  /**
   * Using 2 pointers technique to find 2 indices in the array such that the elements at those
   * indices add up to the target value
   *
   * <p>Time complexity: O(n)<br>
   * Space complexity: O(1)
   *
   * @param nums a sorted array of integers
   * @param target the target sum to find
   * @return an array containing the indices of 2 elements whose sum equals the target
   */
  static int[] twoSumUseTwoPointer(int[] nums, int target) {
    int n = nums.length;
    int left = 0, right = n - 1;

    while (left < right) {
      int sum = nums[left] + nums[right];

      if (sum == target) {
        return new int[] {left, right};
      } else if (sum < target) {
        // Since arr is in ascending order
        // increase left
        left++;
      } else
        // when sum > target, decrease right
        right--;
    }

    return new int[] {};
  }
}
