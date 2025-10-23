package search;

import java.util.*;

public class FirstRepeating {
  public static void main(String[] args) {
    int[] arr = {1, 5, 3, 8, 3, 5, 6};
    System.out.println(firstRepeatingUseNestedLoop(arr));
    System.out.println(firstRepeatingUseMap(arr));
  }

  static int firstRepeatingUseNestedLoop(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (arr[j] == arr[i]) {
          return i;
        }
      }
    }

    return -1;
  }

  static int firstRepeatingUseMap(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    int minIdx = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i]) && map.get(arr[i]) < minIdx) {
        minIdx = map.get(arr[i]);
      }
      map.put(arr[i], i);
    }

    return minIdx == Integer.MAX_VALUE ? -1 : minIdx;
  }
}
