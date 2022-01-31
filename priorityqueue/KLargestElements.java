package DSA.priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KLargestElements {
  
  /**
   * Time Complexity: O(nlogn)
   * Space Complexity: O(1)
   * 
   * O(nlogn) to sort the array and O(k) to print the k largest items
   */
  public static void kLargestElements(int arr[], int n, int k) {
    // Sort the array
    Arrays.sort(arr);

    // Print last k last elements
    for (int i=n-k; i<n; i++) {
      System.out.print(arr[i] + " ");
    }

    System.out.println();
  }

  /**
   * Time Complexity: O(n + k * logn)
   * Space Complexity: O(n)
   * 
   * O(n) time to build the heap and O(k*logn) to get the results
   *  as we are removing k elements from the p-queue and poll() takes O(logn) time
   *  where n are the number of elements in the p-queue
   * But this scenario is for Max heap
   * Solution using Min heap is below 
   */ 
  public static void kLargestElementsMaxHeap(int arr[], int n, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      public int compare(Integer p1, Integer p2) {
        return p2.compareTo(p1);
      }
    });
    
    // Building heap takes O(k) time
    for (int i=0; i<n; i++) {
      pq.add(arr[i]);
    }

    for (int i=0; i<k; i++) {
      System.out.print(pq.poll() + " ");
    }
  }

  /**
   * Time Complexity: O(k + (n-k) * logk)
   * Space Complexity: O(k)
   * 
   * Approach:
   * - Make min heap of k first elements
   * - Now start from k+1 item
   *    - If item is smaller than top of heap, ignore it
   *    - If not then insert that top element and insert current element in the heap
   * - Print contents of min heap
   */
  public static void kLargestElementsBetter(int arr[], int n, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    // Building heap takes O(k) time
    for (int i=0; i<k; i++) {
      pq.add(arr[i]);
    }

    // Comparing and removing elements take O(n-k)*logk time
    for (int i=k; i<n; i++) {
      if (pq.peek() > arr[i]) {
        continue;
      } else {
        pq.poll();
        pq.add(arr[i]);
      }
    }
  
    System.out.println(pq);
  } 

  public static void main(String[] args) {
    int arr[] = {5,15,10,20,8};
    // int newArr[] = {8,6,4,10,9};
    kLargestElements(arr, arr.length, 2);
    // kLargestElements(newArr, newArr.length, 3);
    kLargestElementsBetter(arr, arr.length, 2);
    // kLargestElementsBetter(newArr, newArr.length, 3);
    kLargestElementsMaxHeap(arr, arr.length, 2);
  }
}
