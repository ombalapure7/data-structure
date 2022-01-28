package DSA.priorityqueue;

import java.util.PriorityQueue;

public class KClosestElements {

  /**
   * Time Complexity: O(n*k) 
   * Space Complexity: O(n)
   */
  public static void kClosestElements(int arr[], int n, int k, int x) {
    boolean visited[] = new boolean[n];

    // In each iteration we find element closer to x
    // The logic is similar to finding smallest/largest element
    for (int i = 0; i < k; i++) {
      int minDiff = Integer.MAX_VALUE;
      int minDiffIndex = 0;

      for (int j = 0; j < n; j++) {
        // This logic is similar to finding the smallest no. in an array
        // Difference is that we are finding the difference value here
        if (visited[j] == false && Math.abs(arr[j] - x) <= minDiff) {
          minDiff = Math.abs(arr[j] - x);
          minDiffIndex = j;
        }
      }
      System.out.print(arr[minDiffIndex] + " ");
      visited[minDiffIndex] = true;
    }
    System.out.println();
  }

  /**
   * Time Complexity: O(n-k * logk)
   * Space Complexity: O(k)
   * 
   * Approach: 
   * - Create max heap and add difference of first k elements with x 
   * - Start from k+1 elements, if the difference on top is greater than current
   *      difference then remove the greater diff and add the smaller diff
   * 
   * O(k) + O(n-k * logk) + O(k)
   */
  public static void kClosestElementsBetter(int arr[], int n, int k, int x) {
    // PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
    //   public int compare(Pair p1, Pair p2) {
    //     return p2.getValue().compareTo(p1.getValue());
    //   }
    // });

    PriorityQueue<Pair> pq = new PriorityQueue<>(
        (p1, p2) -> Integer.compare(p2.getValue(), p1.getValue())
      );

    for (int i = 0; i < k; i++) {
      pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
    }

    for (int i = k; i < n; i++) {
      int diff = Math.abs(arr[i] - x);

      if (pq.peek().getValue() > diff) {
        pq.poll();
        pq.offer(new Pair(arr[i], diff));
      }
    }

    while (!pq.isEmpty()) {
      System.out.print(pq.poll().getKey() + " ");
    }
  }

  public static void main(String[] args) {
    int arr[] = { 10, 30, 5, 40, 38, 80, 70 };
    int size = arr.length, x = 35, k = 3;

    kClosestElements(arr, size, k, x);
    kClosestElementsBetter(arr, size, k, x);
  }
}

class Pair {
  Integer key;
  Integer value;

  public Pair(Integer key, Integer value) {
    this.key = key;
    this.value = value;
  }

  public Integer getKey() {
    return key;
  }

  public Integer getValue() {
    return value;
  }
}
