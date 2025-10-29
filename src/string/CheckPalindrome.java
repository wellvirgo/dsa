package string;

public class CheckPalindrome {
  public static void main(String[] args) {
    String s = "abc";
    System.out.println(isPalindromeV1(s));
    System.out.println(isPalindromeV2(s));
  }

  /*
   * Use 2 pointers technique
   *
   * Time complexity: O(n)
   * Space complexity: O(1)
   * */
  static boolean isPalindromeV1(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }

    return true;
  }

  /*
   * Only use a variable for two pointer technique
   *
   * Time complexity: O(n)
   * Space complexity: O(1)
   * */
  static boolean isPalindromeV2(String s) {
    int len = s.length();
    for (int i = 0; i < len / 2; i++) {
      if (s.charAt(i) != s.charAt(len - i - 1)) return false;
    }
    return true;
  }
}
