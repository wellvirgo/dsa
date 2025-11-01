package string;

public class CheckSubSequence {
  public static void main(String[] args) {
    String s1 = "AX";
    String s2 = "ADXCP";
    System.out.println(isSubSequence(s1, s2));
  }

  /*
   * Time complexity: O(n)
   * Space complexity: O(1)
   * */
  static boolean isSubSequence(String s1, String s2) {
    int p1 = 0;

    if (s1.length() >= s2.length()) return false;

    for (int i = 0; i < s2.length(); i++) {
      if (s1.charAt(p1) == s2.charAt(i)) {
        p1++;
      }

      if (p1 == s1.length()) return true;
    }

    return false;
  }
}
