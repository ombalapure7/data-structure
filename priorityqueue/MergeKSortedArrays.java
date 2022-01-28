package DSA.priorityqueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

  /**
   * Time Complexity: O(nk * log(nk)) 
   * Space Complexity: O(nk)
   * 
   * Approach:
   * - Copy all the elements in res[] 
   * - Sort res[]
   * 
   * nk is the total number of elements in the 2D array. So to sort such an array
   *  time taken will be O(nk * lognk) (similar to nlogn)
   */

  /**
   * Time Complexity: O(n * k^2)
   * Space Complexity: O(n*k)
   * 
   * Approach:
   * - We follow the logic of merge sort
   * - We pass 2 arrays to a function that returns merged array for k no. of times
   * 
   * O(n + 2n + 3n + ... + kn) => O(n(1 + 2 + 3 + ... + k)) [Sum of natural numbers]
   * O(n * k(k+1)/2) => O(n * k^2) [Ignore lower order terms]
   */
  public static ArrayList<Integer> mergeKSortedArray(ArrayList<ArrayList<Integer>> arr) {
    ArrayList<Integer> res = arr.get(0);

    // 1st iteraion - merge array at 0th and 1st index
    for (int i=1; i<arr.size(); i++) {
      res = mergeArrays(res, arr.get(i));
    }

    return res;
  }

  // Helper function to merge 2 arrays
  public static ArrayList<Integer> mergeArrays( ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
    int i = 0, j = 0;
    ArrayList<Integer> arr3 = new ArrayList<>();

    while (i < arr1.size() && j < arr2.size()) {
      if (arr1.get(i) < arr2.get(j)) {
        arr3.add(arr1.get(i++));
      } else {
        arr3.add(arr2.get(j++));
      }
    }

    while (i < arr1.size()) {
      arr3.add(arr1.get(i++));
    } 

    while (j < arr2.size()) {
      arr3.add(arr2.get(j++));
    }

    return arr3;
  } 

  /**
   * Time Complexity: O(nk * logk)
   * Space Complexity: O(n*k)
   * 
   * Approach:
   * - We follow the logic of merge sort
   * - We pass 2 arrays to a function that returns merged array for k no. of times
   * 
   * We have to process total n*k elements and we do an insert/remove operation in a heap which contains k elements
   * So overall complexity for n*k elements will be O(nk * logk)
   */
  public static ArrayList<Integer> mergeKSortedArrayBetter(ArrayList<ArrayList<Integer>> arr) {
    ArrayList<Integer> res = new ArrayList<>();
    PriorityQueue<Triplet> pq = new PriorityQueue<Triplet>();

    // Store the 1 value present in every array into the min heap
    for (int i=0; i<arr.size(); i++) {
      // Initially add the 1st element of every array in the heap
      // value, array position, element index in that array
      pq.add(new Triplet(arr.get(i).get(0), i, 0));
    }

    while (!pq.isEmpty()) {
      // We take out the top element from the heap
      // As in min heap the top element is the smallest one
      Triplet curr = pq.poll();
      res.add(curr.val);

      // Get array and element position
      int ap = curr.aPos, vp = curr.vPos;

      // Check if we have some elements in the array with given array position (ap)
      if(vp+1 < arr.get(ap).size()) {
        // Insert the new element from array and update its value position
        pq.add(new Triplet(arr.get(ap).get(vp+1), ap, vp+1));
      }
    }

    return res;
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

    ArrayList<Integer> a1 = new ArrayList<Integer>();
    a1.add(10);
    a1.add(20);
    a1.add(30);
    arr.add(a1);

    ArrayList<Integer> a2 = new ArrayList<Integer>();
    a2.add(5);
    a2.add(15);
    arr.add(a2);

    ArrayList<Integer> a3 = new ArrayList<Integer>();
    a3.add(1);
    a3.add(9);
    a3.add(11);
    a3.add(18);
    arr.add(a3);

    // System.out.println(mergeKSortedArray(arr));
    System.out.println(mergeKSortedArrayBetter(arr));
  }
}

class Triplet implements Comparable<Triplet>{
  int val,aPos,vPos;

  // We need to implement Comparable as we have to store the 
  // elements in the heap values wise
  Triplet(int v,int ap, int vp){
    val = v;
    aPos = ap;
    vPos = vp;
  }

  public int compareTo(Triplet t){
    if(val <= t.val) {
      return -1;
    } else {
      return 1;
    }
  }
}