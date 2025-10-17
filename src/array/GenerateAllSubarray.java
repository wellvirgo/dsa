package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateAllSubarray {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    generateAllSubarray(arr)
        .forEach(subarray -> System.out.println(Arrays.toString(subarray.toArray())));
  }

  /*
   * Time complexity: O(n^3)
   * Space complexity: O(n^3)
   * */
  static List<List<Integer>> generateAllSubarray(int[] arr) {
    int n = arr.length;
    List<List<Integer>> arrList = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      List<Integer> subarray = new ArrayList<>();
      for (int j = i; j < n; j++) {
        subarray.add(arr[j]);
        arrList.add(new ArrayList<>(subarray));
      }
    }

    return arrList;
  }
}
