package DSA.matrix;

import java.util.Arrays;

public class MedianRowSorted {

  /**
   * Time Complexity: O((R*C) * log(R*C))
   * Space Complexity: O(R*C)
   * 
   * Approach:
   * - Traverse matrix and store elements in an array
   * - Sort the array
   * - Return middle element
   * 
   * Complexity: O(R*C) + O((R*C) * (log(R*C)) + O(1)
   */

  /**
   * 
   * Time Complexity: O(R*C)
   * Space Complexity: O(1)
   * 
   * Aprroach:
   * - Find min and max element in the entire matrix
   * - Min element will be in 1st column and max element in last column
   */
  public static int medianRowSortedMatrixBetter(int mat[][], int R, int C) {
    int min = mat[0][0], max = mat[0][C - 1];
    for (int i = 1; i < R; i++) {
      // Min element will be in the first column
      if (mat[i][0] < min) {
        min = mat[i][0];
      }

      // Max element will be in the last column
      if (mat[i][C - 1] > max) {
        max = mat[i][C - 1];
      }
    }

    int medPos = (R * C + 1) / 2;
    while (min < max) {
      int midVal = (min + max) / 2, midPos = 0;
      for (int i = 0; i < R; i++) {
        // Passing every row to the function
        // NOTE: If element is not present, it returns the index where
        // the no. should have been inserted and adds +1 to it
        int pos = Arrays.binarySearch(mat[i], midVal) + 1;
        // midPos = 3 + 5 + 5 in first iteration
        midPos += Math.abs(pos);
      }

      if (midPos < medPos) {
        min = midVal + 1;
      } else {
        max = midVal;
      }
    }

    return min;
  }

  public static void main(String[] args) {
    int arr[][] = { { 5, 10, 20, 30, 40 }, { 1, 2, 3, 4, 6 }, { 11, 13, 15, 17, 19 } };
    System.out.println("Median in the row wise sorted matrix: "
        + medianRowSortedMatrixBetter(arr, arr.length, arr[0].length));
  }
}
