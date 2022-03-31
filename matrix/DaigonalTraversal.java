package DSA.matrix;

public class DaigonalTraversal {

  /**
   * @desc Traverse a matrix diagonally
   * @param arr
   * @param n
   */
  public static void diagonalTraversal(int[][] arr, int n) {
    for (int g = 0; g < n; g++) {
      for (int i = 0, j = g; j < n; i++, j++) {
        System.out.print(arr[i][j] + " ");
      }

      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[][] arr = {
        { 10, 20, 30, 40 },
        { 15, 25, 35, 45 },
        { 27, 29, 37, 48 },
        { 32, 33, 39, 50 }
    };
    
    diagonalTraversal(arr, arr.length);
  }
}
