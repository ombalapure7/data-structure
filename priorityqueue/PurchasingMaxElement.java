package DSA.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PurchasingMaxElement {

  // Find the max no. of elements that add up to the sum/value passed to the function

  /**
   * Time Complexity: O(n * logn) - we are sorting the array
   * Space Complexity: O(1) - if not allowed to mutate the array then space need will be O(n)
   * 
   * A naive approach will be to sort the array After sorting it we traverse it
   *    and start subtracting the values from sum 
   * If not allowed to mutate existing array then space required will be O(n) otherwise it will be O(1)
   */
  public static int purchaseMaxElements(int cost[], int k, int sum) {
    int n = 5;

    int res = 0;
    Arrays.sort(cost);

    for (int i = 0; i < n; i++) {
      // Check whether you can pick the item
      if (cost[i] <= sum) {
        // We can pick the item
        sum -= cost[i];
        res++;
      } else {
        // Cannot buy any more items
        break;
      }
    }

    return res;
  }

  /**
   * Time Complexity: O(n) + O(res * logn) 
   * Space Complexity: O(n)
   * 
   * res: no. of items we can buy
   * 
   * Constructing heap takes O(n) time + extracting min element 
   *    and comparing 'res' no. of times
   * 
   * The solution is better than n * logn
   */
  public static int purchaseMaxElementsBetter(int arr[], int n, int sum) {
    int res = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    // Adding all the elements to the priority queue
    for (int i=0; i<n; i++) {
      pq.add(arr[i]);
    }

    // Subtracting each value from the sum and increase res
    // Elements are in min heap, so least element in the heap will be returned by poll()
    for (int i=0; i<n; i++) {
      // Check whether you can pick the item
      if (pq.peek() <= sum) {
        sum -= pq.poll();
        res++;
      } 
    }

    return res;
  }

  public static void main(String[] args) {
    int arr[] = { 2, 6, 3, 12, 56, 8 };
    int sum = 10;
    System.out.println("Max elements we can buy - Naive: " + purchaseMaxElements(arr, arr.length, sum));
    int newArr[] = { 2, 6, 3, 12, 56, 8 };
    sum = 10;
    System.out.println("Max elements we can buy - Efficient: " + purchaseMaxElements(newArr, newArr.length, sum));
  }
}
