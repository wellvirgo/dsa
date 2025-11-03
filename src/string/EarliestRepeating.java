package string;

import java.util.HashMap;
import java.util.Map;

public class EarliestRepeating {
  public static void main(String[] args) {
    String s = "hello geeks";
    System.out.println(findEarliestRepeatingV1(s));
    System.out.println(findEarliestRepeatingV2(s));
    System.out.println(findEarliestRepeatingV3(s));
  }

  /*
   * Time complexity: O(n^2)
   * Space complexity: O(1)
   * */
  static String findEarliestRepeatingV1(String s) {
    int minIdx = Integer.MAX_VALUE;

    for (int i = 0; i < s.length(); i++) {
      for (int j = s.length() - 1; j > i; j--) {
        if (s.charAt(j) == s.charAt(i) && j < minIdx) {
          minIdx = j;
        }
      }
    }

    return minIdx != Integer.MAX_VALUE ? Character.toString(s.charAt(minIdx)) : "-1";
  }

  /*
   * This approach is better the above algorithm
   * For each character, check it has already appeared earlier in the string
   *
   *  Time complexity: O(n^2)
   * Space complexity: O(1)
   * */
  static String findEarliestRepeatingV2(String s) {
    int n = s.length();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (s.charAt(j) == s.charAt(i)) {
          return Character.toString(s.charAt(j));
        }
      }
    }

    return "-1";
  }

  /*
   * Using has map
   *
   *  Time complexity: O(n)
   * Space complexity: O(1)
   * */
  static String findEarliestRepeatingV3(String s) {
    int n = s.length();

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      int hash = s.charAt(i) - 'a';
      if (map.containsKey(hash)) {
        return Character.toString(s.charAt(i));
      }
      map.put(hash, i);
    }

    return "-1";
  }
}
