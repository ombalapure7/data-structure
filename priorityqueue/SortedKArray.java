package DSA.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortedKArray {
  // Means array is somewhat sorted, we need to sort it properly for eg:
  // 9,8,7,19,18

  /**
   * A Naive approach will be to call sort function on the array
   * Time Complexity: O(nlogn)
   */

  /**
   * Time Complexity: O(n*logk)
   * Space Complexity: O(n)
   * 
   * Since we are processing k elements and insert/delete operations in a heap cost is O(logk)
   * O(k+1*logk) + O(n-k*logk) + O(klogk) =~ O(n*logk)
   */
  public static int[] sortKSortedArray(int arr[], int n, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    // O(k+1*logk)
    for (int i = 0; i < k; i++) {
      // Place first k elements in the heap
      pq.add(arr[i]);
    }

    // Index to maintain insertion in the array
    int index = 0;

    // O(n-k*logk)
    // Start the loop from k+1 index as 1st k elements 
    //    have already been processed 
    for (int i = k; i < n; i++) {
      // Top/smallest element of heap goes to the 1st index of array
      arr[index++] = pq.poll();
      // We have to process other elements, so place them in heap
      // This way elements will come out in increasing order from the heap
      pq.add(arr[i]);
    }

    // O(klogk)
    while (!pq.isEmpty()) {
      // Get remaining elements from the heap
      arr[index++] = pq.poll();
    }

    return arr;
  }

  public static void main(String[] args) {
    int k = 3;
    int arr[] = { 2, 6, 3, 12, 56, 8 };
    System.out.println("Sorted array: " + Arrays.toString(sortKSortedArray(arr, arr.length, k)));
  }
}
