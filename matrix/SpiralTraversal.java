package DSA.matrix;

public class SpiralTraversal {
  
  /*
   * Time Complexity: O(n^2) 
   * Space Complexity: O(n^2)
   * 
   * Approach:
   * - Have 4 variables to keep track of the traversal
   * - top goes down ++
   * - right goes left -- 
   * - bottom goes up -- 
   * - left goes right ++
   */
  public static void spiralTraversal(int mat[][], int R, int C) {
    int top=0, left=0, bottom=R-1, right=C-1;
    while (top <= bottom && left <= right) {
      // Prints row forward
      for (int i=left; i<=right; i++) {
        System.out.print(mat[top][i] + " ");
      }
      // Switch to next row - downward
      top++;

      // Prints column downward
      for (int i=top; i<=bottom; i++) {
        System.out.print(mat[i][right] + " ");
      } 
      // Move to left 1 step
      right--;

      // Prints row backward
      if (top <= bottom) {
        for (int i=right; i>=left; i--) {
          System.out.print(mat[bottom][i] + " ");
        }
        // Move tp 1 step
        bottom--;
      }

      // Prints column upward
      if (left <= right) {
        for (int i=bottom; i>=top; i--) {
          System.out.print(mat[i][left] + " ");
        }
        // Switch to next row - upward
        left++;
      }
    }
  }

  public static void main(String[] args) {
    int arr[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
    System.out.println("Spiral traveral of a Matrix:");
    spiralTraversal(arr, arr.length, arr[0].length);
  }  
}
