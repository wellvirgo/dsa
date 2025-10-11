package array;

import java.util.Arrays;

public class InsertGivenPos {
  public static void main(String[] args) {
    int[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    insertGivenPosV1(a1, 5, 10);

    System.out.println("--------------------");

    int[] a2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    insertGivenPosV2(a2, 5, 10);
  }

  /*
   * Use a custom method instead of the add() of ArrayList
   * Time complexity: O(n)
   * Space complexity: O(1)
   * */
  static void insertGivenPosV1(int[] a, int pos, int val) {
    System.out.println("Array before insertion");
    System.out.println(Arrays.toString(a));

    int n = a.length;
    for (int i = n - 1; i >= pos; i--) {
      a[i] = a[i - 1];
    }

    a[pos - 1] = val;

    System.out.println("Array after insertion");
    System.out.println(Arrays.toString(a));
  }

  /*
   * Use a custom method instead of the add() of ArrayList
   * Time complexity: O(n)
   * Space complexity: O(n)
   * */
  static void insertGivenPosV2(int[] a, int pos, int val) {
    System.out.println("Array before insertion");
    System.out.println(Arrays.toString(a));

    int n = a.length;
    int[] newArr = new int[n + 1];

    System.arraycopy(a, 0, newArr, 0, n);

    for (int i = newArr.length - 1; i >= pos; i--) {
      newArr[i] = newArr[i - 1];
    }

    newArr[pos - 1] = val;

    System.out.println("Array after insertion");
    System.out.println(Arrays.toString(newArr));
  }
}
