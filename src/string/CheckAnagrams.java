package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckAnagrams {
  /*
   * 2 strings are anagrams if they have the same characters
   * with the same frequencies
   * */

  public static void main(String[] args) {
    String s1 = "geeks";
    String s2 = "kseeg";
    System.out.println(isAnagramVer1(s1, s2));
    System.out.println(isAnagramVer2(s1, s2));
  }

  /*
   * m: length of s1
   * n: length of s2
   *
   * Using Arrays.sort() and equal 2 strings after sorting
   *
   * Time complexity: O(m*log(m) + n*log(n))
   * Space complexity: O(m + n)
   * */
  static boolean isAnagramVer1(String s1, String s2) {
    char[] s1Chars = s1.toCharArray();
    char[] s2Chars = s2.toCharArray();

    Arrays.sort(s1Chars);
    Arrays.sort(s2Chars);

    return Arrays.equals(s1Chars, s2Chars);
  }

  /*
   * m: length of s1
   * n: length of s2
   *
   * Using a Map to store the frequencies of
   * the characters in a string
   * Then iterating through another string,
   * each the same element decrease the frequencies in the map
   * At the end, if the map only have value 0
   * 2 string is anagrams otherwise not anagrams
   *
   * Time complexity: O(m + n)
   * Space complexity: O(n)
   * */
  static boolean isAnagramVer2(String s1, String s2) {
    if (s1.length() != s2.length()) return false;

    Map<Character, Integer> charCount = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
      char c = s1.charAt(i);
      if (!charCount.containsKey(c)) {
        charCount.put(c, 1);
      } else {
        int count = charCount.get(c);
        charCount.put(c, ++count);
      }
    }

    for (int i = 0; i < s2.length(); i++) {
      char c = s2.charAt(i);
      if (charCount.containsKey(c)) {
        int count = charCount.get(c);
        charCount.put(c, --count);
      }
    }

    for (var entry : charCount.entrySet()) {
      if (entry.getValue() != 0) return false;
    }
    return true;
  }
}
