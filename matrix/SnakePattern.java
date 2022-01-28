package DSA.matrix;

public class SnakePattern {

  /*
   * Time Complexity: O(rows*cols) 
   * Space Complexity: O(1)
   */
  public static void snakePattern(int mat[][], int rows, int cols) {
    for (int i=0; i<rows; i++) {
      // Print the row from left -> right for i=0,2,4...
      if (i % 2 == 0) {
        for (int j=0; j<cols; j++) {
          System.out.print(mat[i][j] + " ");
        }
      } 
      // Print the row from right -> left for i=1,3,5...
      else {
        for (int j=cols-1; j>=0; j--) {
          System.out.print(mat[i][j] + " ");
        }
      }

      System.out.println();
    }
  }

  public static void main(String[] args) {
    int arr[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
    System.out.println("Snake Pattern in Matrix");
    snakePattern(arr, arr.length, arr[0].length);
  }
}