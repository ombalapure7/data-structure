package DSA.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {
  // Median of a seq is the element that is smaller and greater than half of
  // elements
  // Incase of an odd no. of elements there will be one median
  // Incase of even no. of elements the median is calculated as average of 2
  // middle elements

  /**
   * Time Complexity: O(n^2) Space Complexity: O(n)
   * 
   * Approach: 
   * - Create temp array and maintain (sort) the sequence 
   * - To maintain temp array we need to move all the existing elements
   */
  public static void medianStream(double arr[], int n) {
    double[] temp = new double[n];
    int size = 0;

    // Sort the array everytime a new element is inserted in "temp" array
    for (int i = 0; i < n; i++) {
      // Temp array to store the median
      temp[i] = arr[i];
      size++;
      int j = i;
      
      // For every element we have to do O(n) work
      while (j > 0 && temp[j] < temp[j - 1]) {
        double a = temp[j];
        temp[j] = temp[j - 1];
        temp[j - 1] = a;
        j--;
      }

      if (size % 2 != 0) {
        // If there are odd no. of elements in temp, print middle element
        System.out.print(temp[size / 2] + " ");
      } else {
        // If there are even no. of elements in temp, print average of 2 middle elements
        System.out.print(((temp[size / 2] + temp[(size - 1) / 2]) / 2) + " ");
      }
    }
  }

  /**
   * Time Complexity: O(n * logn)
   * Space Complexity: O(n + m)
   * 
   * Approach: 
   * - Maintain two containers, first one contain smaller half and second one greater half elements 
   * - For greater one we can have max heap and smaller one we can have min heap
   * - Take the max element from min heap and min element from the max heap, and find the average 
   * - In case odd elements put an extra element in the min heap and print the largest element of the max heap
   * - If there are even no. elements in total (min + max heap) then find the average of - largest in max heap and smallest in min heap
   */
  public static void medianOfStreamBetter(int arr[], int n) {
    // Contain smaller half elements
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // Contain larger half elements
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    /* NOTE: We try to put smaller elements in the max heap and bugger elements in min heap  */

    maxHeap.add(arr[0]);
    System.out.print(arr[0] + " ");

    for (int i = 1; i < n; i++) {
      int x = arr[i];
      // No. of elements are not balanced
      if (maxHeap.size() > minHeap.size()) {
        if (maxHeap.peek() > x) {
          minHeap.add(maxHeap.poll());
          // Add smaller elements to the max heap
          maxHeap.add(x);
        } else {
          // Add greater elements to the min heap
          minHeap.add(x);
        }

        System.out.print(((double) (maxHeap.peek() + minHeap.peek()) / 2) + " ");
      } else {
        // The elements are balanced in the heaps
        if (x <= maxHeap.peek()) {
          // Current element is smaller than max element in max heap
          // Add that element to the max heap
          maxHeap.add(x);
        } else {
          // Current element is greater than max element in max heap 
          // Add that element to the min heap
          minHeap.add(x);
          maxHeap.add(minHeap.poll());
        }
        System.out.print(maxHeap.peek() + " ");
      }
    }
  }

  public static void main(String[] args) {
    double[] arr = new double[] { 25, 7, 10, 15, 20 };
    // Op: 25.0 16.0 10.0 12.5 15.0
    medianStream(arr, arr.length);

    System.out.println();

    int newArr[] = {12, 15, 10, 5, 8, 7, 16};
    // Op: 12 13.5 12 11.0 10 9.0 10 
    medianOfStreamBetter(newArr, newArr.length);
  }
}
