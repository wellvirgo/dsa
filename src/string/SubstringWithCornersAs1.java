package string;

public class SubstringWithCornersAs1 {
  /*
   * Given a binary string s,
   * the task is to count all substrings that start and end with the character '1'.
   * A valid substring must have both its first and last characters as '1',
   * and can include one or more number of characters in between.
   * */

  public static void main(String[] args) {
    String str = "00100101";
    System.out.println(substringWithCornersAs1Ver1(str));
    System.out.println(substringWithCornersAs1Ver2(str));
  }

  /*
   * Time complexity: O(n^2)
   * Space complexity: O(1)
   * */
  static int substringWithCornersAs1Ver1(String str) {
    int count = 0, i = 0;
    while (i < str.length() - 1) {
      if (str.charAt(i) != '1') {
        i++;
        continue;
      }

      for (int j = i + 1; j < str.length(); j++) {
        if (str.charAt(j) == '1') {
          count++;
        }
      }

      i++;
    }

    return count;
  }

  /*
   * Use the Math formula: n*(n-1)/2
   * Since two appearances of 1 will create a valid substring
   *
   * Time complexity: O(n)
   * Space complexity: O(1)
   * */
  static int substringWithCornersAs1Ver2(String str) {
    int appearanceOf1 = countAppearanceOf1(str);

    return appearanceOf1 * (appearanceOf1 - 1) / 2;
  }

  static int countAppearanceOf1(String str) {
    int count = 0;

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '1') count++;
    }

    return count;
  }
}
