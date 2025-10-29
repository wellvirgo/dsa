package string;

import java.util.ArrayList;

public class CheckPangram {
  public static void main(String[] args) {
    String s = "The quick brown fox jumps over he lazy dog";
    System.out.println(isPangramV1(s));
    System.out.println(isPangramV2(s));
    System.out.println(isPangramV3(s));
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(1)
   * */
  static boolean isPangramV1(String s) {
    for (char ch = 'a'; ch <= 'z'; ch++) {
      boolean found = false;

      for (int i = 0; i < s.length(); i++) {
        if (ch == Character.toLowerCase(s.charAt(i))) {
          found = true;
          break;
        }
      }

      if (!found) {
        return false;
      }
    }

    return true;
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(n)
   * */
  static boolean isPangramV2(String s) {
    ArrayList<Character> visited = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      visited.add(Character.toLowerCase(s.charAt(i)));
    }

    for (char ch = 'a'; ch <= 'z'; ch++) {
      boolean found = visited.contains(ch);
      if (!found) {
        return false;
      }
    }

    return true;
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(MAX_CHARS)
   * with MAX_CHARS = 26 ('a' -> 'z')
   * */
  static boolean isPangramV3(String s) {
    final int MAX_CHARS = 26;
    boolean[] visited = new boolean[MAX_CHARS];

    for (int i = 0; i < s.length(); i++) {
      char c = Character.toLowerCase(s.charAt(i));
      if (c >= 'a' && c <= 'z') {
        visited[c - 'a'] = true;
      }
    }

    for (int i = 0; i < MAX_CHARS; i++) {
      if (!visited[i]) return false;
    }

    return true;
  }
}
