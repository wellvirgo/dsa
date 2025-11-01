package string.pattern_searching;

public class CheckSubString {
  public static void main(String[] args) {
    String s = "Xin chao, Hello world";
    String pat = "in ";
    System.out.println(subString(s, pat));
  }

  /**
   * Time complexity: O(n^2)</br> Space complexity: O(1)
   *
   * @param s The original string
   * @param pat The pattern that need to be checked
   * @return 1 if pat is substring, otherwise return 0
   */
  static int subString(String s, String pat) {
    int n = s.length();
    int m = pat.length();

    if (n == 0 || m == 0 || m > n) return -1;

    for (int i = 0; i <= n - m; i++) {
      int j;
      for (j = 0; j < m; j++) {
        if (s.charAt(i + j) != pat.charAt(j)) {
          break;
        }
      }

      if (j == m) return i;
    }

    return -1;
  }
}
