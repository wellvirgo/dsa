package sort;

public class SortString {
  static final int MAX_CHARS = 26;

  public static void main(String[] args) {
    String s = "geeksforgeeks";

    // ========== Test quickSortString() ==========
    /*char[] chars = s.toCharArray();
    quickSortString(chars, 0, s.length() - 1);
    System.out.println(new String(chars));*/

    // ========== Test sortString() ==========
    System.out.println(sortString(s));
  }

  static int hoarePartition(char[] chars, int low, int high) {
    char pivot = chars[low];
    low--;
    high++;

    while (true) {
      do {
        low++;
      } while (chars[low] < pivot);

      do {
        high--;
      } while (chars[high] > pivot);

      if (low >= high) {
        return high;
      }

      char temp = chars[low];
      chars[low] = chars[high];
      chars[high] = temp;
    }
  }

  /*
   * Time complexity: O(n*log(n))
   * Space complexity: O(log(n))
   * */
  static void quickSortString(char[] chars, int low, int high) {
    if (low < high) {
      int pi = hoarePartition(chars, low, high);

      quickSortString(chars, low, pi);
      quickSortString(chars, pi + 1, high);
    }
  }

  /*
   * Time complexity: O(MAX_CHARS*n) can be simplified to O(n)
   * Space complexity: O(MAX_CHARS)
   * */
  static String sortString(String s) {
    // Contains 26 letters from 'a'->'z'
    int[] occurrences = new int[MAX_CHARS];

    for (int i = 0; i < s.length(); i++) {
      occurrences[s.charAt(i) - 'a']++;
    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < MAX_CHARS; i++) {
      for (int j = 0; j < occurrences[i]; j++) {
        result.append((char) ('a' + i));
      }
    }

    return result.toString();
  }
}
