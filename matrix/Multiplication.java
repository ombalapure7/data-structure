package DSA.matrix;

public class Multiplication {

  /**
   * @desc Multiply 2 matrices
   * @param a
   * @param b
   * 
   *          COMPLEXITY
   *          Time: O(n*n)
   *          Space: O(1)
   */
  public static void multiply(int[][] a, int[][] b) {
    int n = a.length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int res = 0;
        for (int k = 0; k < n; k++) {
          res += a[i][k] * b[k][j];
        }

        System.out.print(res + " ");
      }

      System.out.println();
    }
  }

  public static void main(String[] args) {
    int a[][] = {
        { 1, 1, 1, 1 },
        { 2, 2, 2, 2 },
        { 3, 3, 3, 3 },
        { 4, 4, 4, 4 }
    };

    int b[][] = {
        { 1, 1, 1, 1 },
        { 2, 2, 2, 2 },
        { 3, 3, 3, 3 },
        { 4, 4, 4, 4 }
    };

    multiply(a, b);
  }
}
