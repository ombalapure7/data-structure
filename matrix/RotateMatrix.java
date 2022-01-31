package DSA.matrix;

public class RotateMatrix {

  /*
   * Time Complexity: O(n^2) 
   * Space Complexity: O(n^2)
   * 
   * Last column becomes first row
   */
  public static void rotateMatrix(int mat[][], int n) {
    int temp[][] = new int[n][n];
    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        temp[n-j-1][i] = mat[i][j];
      }
    }

    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        System.out.print(temp[i][j] + " ");
      }
      System.out.println();
    }
  }

  /*
   * Time Complexity: O(n^2) 
   * Space Complexity: O(1)
   * 
   * Approach:
   * - Transpose a matrix
   * - Reverse each column
   */
  public static void rotateMatrixBetter(int mat[][], int n) {
    for (int i=0; i<n; i++) {
      for (int j=i+1; j<n; j++) {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
      }
    }

    for (int i=0; i<n; i++) {
      int low = 0, high = n-1;
      while (low < high) {
        int temp = mat[low][i];
        mat[low][i] = mat[high][i];
        mat[high][i] = temp;

        low++;
        high--;
      }      
    }

    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        System.out.print(mat[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int arr[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
    System.out.println("Rotate Matrix 90deg counter clockwise: ");
    rotateMatrix(arr, arr.length);

    int newArr[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
    System.out.println("Rotate Matrix 90deg counter clockwise - Efficient: ");
    rotateMatrixBetter(newArr, newArr.length);
  }
}
