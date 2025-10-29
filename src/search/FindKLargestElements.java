package search;

import java.util.*;

public class FindKLargestElements {
  public static void main(String[] args) {
    int[] arr = {11, 5, 12, 9, 44, 17, 2};
    int k = 5;
    System.out.println(findKLargestUseSort(arr, k));
    System.out.println(findKLargestUseMinHeap(arr, k));
  }

  /*
   * Time complexity: O(n*log(n))
   * Space complexity: O(n)
   * */
  static ArrayList<Integer> findKLargestUseSort(int[] arr, int k) {
    Integer[] arrInt = Arrays.stream(arr).boxed().toArray(Integer[]::new);

    // Use TimSort
    Arrays.sort(arrInt, Collections.reverseOrder());

    return new ArrayList<>(Arrays.asList(arrInt).subList(0, k));
  }

  /*
   * Time complexity: O(n*log(k))
   * Space complexity: O(k)
   * */
  static ArrayList<Integer> findKLargestUseMinHeap(int[] arr, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>(k);

    for (int i = 0; i < k; i++) heap.add(arr[i]); // Tc: O(k*log(k))

    // Tc: O((n-k)*log(k))
    for (int i = k; i < arr.length; i++) {
      if (arr[i] > heap.peek()) {
        heap.poll(); // Tc: O(log(k))
        heap.add(arr[i]); // Tc: O(log(k))
      }
    }

    ArrayList<Integer> result = new ArrayList<>();
    // Tc: O(k*log(k))
    while (!heap.isEmpty()) {
      result.add(heap.poll());
    }
    Collections.reverse(result);

    return result;
  }
}
