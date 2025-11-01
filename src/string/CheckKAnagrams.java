package string;

import java.util.HashMap;
import java.util.Map;

public class CheckKAnagrams {
  /*
  * 2 strings are called k-anagrams if:
  * Both have same number of characters
  * 2 strings can be anagrams by changing at most K characters in a string
  * */

  public static void main(String[] args) {
    String s1 = "anagram";
    String s2 = "grammar";

    System.out.println(isKAnagram(s1, s2, 1));
  }

  /*
  * Time complexity: O(n)
  * Space complexity: O(1)
  * */
  static boolean isKAnagram(String str1, String str2, int k) {
    if (str1.length() != str2.length()) return false;

    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < str1.length(); i++) {
      char c = str1.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (int i = 0; i < str2.length(); i++) {
      char c = str2.charAt(i);
      // don't decrease if the frequencies = 0
      if (map.getOrDefault(c, 0) > 0) {
        map.put(c, map.get(c) - 1);
      }
    }

    int count = 0;
    for (var entry : map.entrySet()) {
      count += entry.getValue();
    }

    return count <= k;
  }
}
