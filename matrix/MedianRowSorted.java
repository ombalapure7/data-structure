// package DSA.matrix;

// import java.util.Arrays;

// public class MedianRowSorted {
  
//   /**
//    * Time Complexity: O((R*C) * log(R*C)) 
//    * Space Complexity: O(R*C)
//    * 
//    * Approach:
//    * - Traverse matrix and store elements in an array
//    * - Sort the array 
//    * - Return middle element 
//    * 
//    * Complexity: O(R*C) + O((R*C) * (log(R*C)) + O(1)
//    */

   
//   /**
//    * 
//    * Time Complexity: O(R*C) 
//    * Space Complexity: O(1)
//    * 
//    * Aprroach:
//    * - Find min and max element 
//    * - Min element will be in 1st column and max element in last column
//    */
//   public static int medianRowSortedMatrixBetter(int mat[][], int R, int C) {
//     int min = mat[0][0], max = mat[0][C-1];
//     for (int i=1; i<R; i++) {
//       if (mat[i][0] < min) {
//         min = mat[i][0];
//       }

//       if (mat[i][C-1] > max) {
//         max = mat[i][C-1];
//       }
//     }

//     int medianPos = (R * C + 1)/2;
//     while (min < max) {
//       int mid = (min + max)/2;
//       for (int i=0; i<R; i++) {
//         int pos = Arrays.binarySearch(mat[i], mid) + 1;
//       }
//     }

//     return -1;
//   }

//   public static void main(String[] args) {
//     int arr[][] = {{5,10,20,30,40}, {1,2,3,4,6}, {11,13,15,17,19}};
//     System.out.println("Median in the matrix: " 
//             + medianRowSortedMatrixBetter(arr, arr.length, arr[0].length));
//   }
// }
