package array;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {

  /*
  * Find the Leaders in a given int array.
  * An element is Leader if it is greater than or equal to
  * all the elements to its right.
  * The last element is always a Leader.
  * */

  public static void main(String[] args) {
    int[] arr = {0, 4, 5, 1, 2};
    getLeadersV1(arr).forEach(System.out::println);
    System.out.println("-------------");
    getLeadersV2(arr).forEach(System.out::println);
  }

  /*
  * Nested loop approach
  * Time complexity: O(n^2)
  * Space complexity: O(n)
  * */
  static ArrayList<Integer> getLeadersV1(int[] arr) {
    var leaders = new ArrayList<Integer>();
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      int j;

      for (j = i + 1; j < n; j++) {
        if (arr[j] > arr[i]) {
          break;
        }
      }

      if (j == n) {
        leaders.add(arr[i]);
      }
    }

    return leaders;
  }

  /*
  * From right to left and track max
  * Time complexity: O(n)
  * Space complexity: O(n)
  * */
  static ArrayList<Integer> getLeadersV2(int[] arr) {
    var leaders = new ArrayList<Integer>();
    int n = arr.length;
    int max = arr[n - 1];
    leaders.add(max);

    for (int i = n - 2; i >= 0; i--) {
      if (arr[i] >= max) {
        max = arr[i];
        leaders.add(max);
      }
    }
    Collections.reverse(leaders);
    return leaders;
  }
}
