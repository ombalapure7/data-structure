package DSA.matrix;

public class BoundaryTraversal {

  /*
   * Time Complexity: O(2rows + 2cols) =~ O(rows+cols) 
   * Space Complexity: O(1)
   */
  public static void boundaryTraversal(int mat[][], int rows, int cols) {
    // Handle edge case if no. of rows=1
    if (rows == 1) {
      for (int i=0; i<cols; i++) {
        System.out.print(mat[0][i]);
      }

      System.out.println();
    }
    // Handle edge case if no. of cols=1
    else if (cols == 1) {
      for (int i=0; i<rows; i++) {
        System.out.print(mat[i][0]);
      }

      System.out.println();
    }
    // Print the boundary elements
    else {
      // Top elements
      for (int i=0; i<cols; i++) {
        System.out.print(mat[0][i] + " ");
      }

      // Right elements
      for (int i=1; i<rows; i++) {
        System.out.print(mat[i][cols-1] + " ");
      }

      // Bottom elements
      for (int i=cols-2; i>=0; i--) {
        System.out.print(mat[rows-1][i] + " ");
      }

      // Left elements
      for (int i=rows-2; i>=1; i--) {
        System.out.print(mat[i][0] + " ");
      }
    }
  }

  public static void main(String[] args) {
    int arr[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
    System.out.println("Boundary Traversal in Matrix");
    boundaryTraversal(arr, arr.length, arr[0].length);
  }
}
