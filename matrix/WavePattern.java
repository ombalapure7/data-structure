package DSA.matrix;

public class WavePattern {

  /**
   * @desc Traverse an a 2D array in a wave pattern
   * @param a
   * @param n
   * 
   *          COMPLEXITY
   *          Time: O(n*n)
   *          Space: O(1)
   */
  public static void wavePattern(int[][] a, int n) {
    for (int i = 0; i < a[0].length; i++) {
      if (i % 2 == 0) {
        for (int j = 0; j < n; j++) {
          System.out.print(a[j][i] + " ");
        }
      } else {
        for (int j = n - 1; j >= 0; j--) {
          System.out.print(a[j][i] + " ");
        }
      }
    }
  }

  public static void main(String[] args) {
    int[][] arr = {
        { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 },
        { 17, 18, 19, 20 }
    };

    wavePattern(arr, arr.length);
  }
}
