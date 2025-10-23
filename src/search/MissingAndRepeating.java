package search;

import java.util.ArrayList;

public class MissingAndRepeating {
  public static void main(String[] args) {
    int[] arr = {4, 3, 6, 2, 1, 1};
    System.out.println(findMissingAndRepeating(arr));
  }

  static ArrayList<Integer> findMissingAndRepeating(int[] arr) {
    int n = arr.length;
    int[] freq = new int[n + 1];
    int missing = -1, repeating = -1;

    for (int i : arr) {
      freq[i]++;
    }

    var res = new ArrayList<Integer>();
    for (int i = 1; i <= n; i++) {
      if (freq[i] == 0) missing = i;
      else if (freq[i] == 2) repeating = i;
    }

    res.add(repeating);
    res.add(missing);

    return res;
  }
}
